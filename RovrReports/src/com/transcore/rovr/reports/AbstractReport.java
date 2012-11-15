//=============================================================================
//  Class AbstractReport - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transcore.rovr.reports;

//*****************************************************************************

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

// Name: AbstractReport.java
//
// Project: com.Transcore.ROVR - AbstractReport
//
// Author: pyovich
//
// Purpose: TODO: Base class used to generate reports
//
//		(c) 2012 TransCore, LP.  All rights reserved.
//
//*****************************************************************************
// Updates:
// --------  ----- ------------------------------------------------------------
// Sep 26, 2012 -  V1.0 - Created
//
//*****************************************************************************
public abstract class AbstractReport implements Serializable {

    JasperPrint jasperPrint;
    String reportFileName = "UndefindedReport";
    
    public String getReportFileName () {
        return reportFileName;
    }
    
    public abstract void init();
    
    public void writePDFFile(String outputFileName) {
        try {
        init();
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputFileName);
        Logger.getLogger("AbstractReport").log(Level.INFO, "<renderPDF done>");
        } catch (Exception ex) {
            Logger.getLogger("AbstractReport").log(Level.WARNING, "<renderPDF>", ex);
        }
    }
    
    public void writeDOCX(String outputFileName) throws JRException, IOException {
        init();
        JRDocxExporter docxExporter = new JRDocxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
        docxExporter.exportReport();
    }

    public void writeXLSX(String outputFileName) throws JRException, IOException {
        init();
        JRXlsxExporter docxExporter = new JRXlsxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
        docxExporter.exportReport();
    }

    public void writeODT(String outputFileName) throws JRException, IOException {
        init();
        JROdtExporter exporter = new JROdtExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
        exporter.exportReport();
    }

    public void writePPT(String outputFileName) throws JRException, IOException {
        init();
        JRPptxExporter docxExporter = new JRPptxExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
        docxExporter.exportReport();
    }
    
    public void writeCSV() throws JRException, IOException {
        init();
        JRCsvExporter docxExporter = new JRCsvExporter();
        docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        docxExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, reportFileName);
        docxExporter.exportReport();
    }
}
