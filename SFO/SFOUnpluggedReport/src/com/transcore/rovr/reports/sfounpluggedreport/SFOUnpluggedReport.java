/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.reports.sfounpluggedreport;

import com.transcore.rovr.database.StoredProcedureGateway;
import com.transcore.rovr.reports.UnpluggedReport;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 *
 * @author Peter
 */
public class SFOUnpluggedReport {

    @Option(name = "-account", usage = "accountId")
    private int accountId;
    @Option(name = "-userId", usage = "UserId to run report as")
    private int userId = 4;
    @Option(name = "-numHours", usage = "number of hours for reporting")
    private int numHours = 24;
    @Option(name = "-timeZone", usage = "timeZone to cast times as")
    private String timeZone = "CT";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        new SFOUnpluggedReport().doMain(args);
    }

    public void doMain(String[] args) throws SQLException {

        CmdLineParser parser = new CmdLineParser(this);
        parser.setUsageWidth(80);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java SFOUnpluggedReport [options...] arguments...");
            parser.printUsage(System.err);
            System.err.println();
            return;
        }

        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        SimpleDateFormat dateTime = new SimpleDateFormat("yyyyMMddHHmmss");

        File reportLocation = new File("reports");
        // if the directory does not exist, create it
        if (!reportLocation.exists()) {
            reportLocation.mkdir();
        }
        
        String fileName = "reports/SFOUnpluggedReport_" + dateTime.format(now) + ".pdf";
        String pathlessFileName = "SFOUnpluggedReport_" + dateTime.format(now) + ".pdf";
        
        UnpluggedReport report = new UnpluggedReport();

        report.userId = userId;
        report.accountId = accountId;
        report.numHours = numHours;
        report.timeZone = timeZone;

        report.writePDFFile(fileName);

        StoredProcedureGateway.HandleReportResults("SFOUnpluggedReport", now, pathlessFileName, accountId, userId);
    }
}
