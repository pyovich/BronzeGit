/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.reports.sfonoresponse;

import com.transcore.rovr.database.StoredProcedureGateway;
import com.transcore.rovr.reports.NoResponseReport;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 *
 * @author pyovich
 */
public class SFONoResponse {

    @Option(name = "-account", usage = "accountId")
    private int accountId;
    @Option(name = "-userId", usage = "UserId to run report as")
    private int userId = 9;
    @Option(name = "-threshold", usage = "number of hours before device is reported")
    private double threshold = 0.5;
    @Option(name = "-timeZone", usage = "timeZone to cast times as")
    private String timeZone = "CT";
    @Argument
    private List<String> arguments = new ArrayList<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        new SFONoResponse().doMain(args);
    }

    public void doMain(String[] args) throws SQLException {

        CmdLineParser parser = new CmdLineParser(this);
        parser.setUsageWidth(80);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java SFONoResponse [options...] arguments...");
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
        
        String fileName = "reports/SFONoResponse_" + dateTime.format(now) + ".pdf";
        String pathlessFileName = "SFONoResponse_" + dateTime.format(now) + ".pdf";
        
        NoResponseReport noResponse = new NoResponseReport();

        noResponse.userId = userId;
        noResponse.accountId = accountId;
        noResponse.threshold = threshold;
        noResponse.timeZone = timeZone;

        noResponse.writePDFFile(fileName);

        StoredProcedureGateway.HandleReportResults("SFONoResponse", now, pathlessFileName, accountId, userId);
    }
}
