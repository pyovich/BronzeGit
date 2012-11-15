//=============================================================================
//  Class SafetySummaryReport - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transcore.rovr.reports;

//*****************************************************************************

import com.transcore.rovr.database.StoredProcedureGateway;
import com.transcore.rovr.database.objects.EventTrxnItem;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

// Name: SafetySummaryReport.java
//
// Project: com.transcore.rovr.reports - SafetySummaryReport
//
// Author: pyovich
//
// Purpose: TODO: Add Purpose Description 
//
//		(c) 2012 TransCore, LP.  All rights reserved.
//
//*****************************************************************************
// Updates:
// --------  ----- ------------------------------------------------------------
// Nov 14, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class SafetySummaryReport extends AbstractReport {

    public int deviceId;
    public int accountId;
    public Timestamp startDate;
    public Timestamp endDate;
    public int userId;
    
    @Override
    public void init() {
        
        String reportPath = "SFONoResponse.jasper";

        // Fill the parameters
        Map parameters = new HashMap();
                
        // Gather the data
        Collection formData = new ArrayList();

        List result;
        try {
            result = StoredProcedureGateway.getWeeklySummary_STUB(deviceId, accountId, startDate, endDate, userId);
        } catch (Exception ex) {
            result = null;
        }

//        Collections.sort(result, new Comparator<EventTrxnItem>() {
//            @Override
//            public int compare(EventTrxnItem i1, EventTrxnItem i2) {
//                return i1.getAccountName().compareTo(i2.getAccountName());
//            }
//        });

        System.out.println("Total Records found: " + result.size());

        // Fill the report
        try {
            jasperPrint = JasperFillManager.fillReport(
                    reportPath,
                    parameters,
                    new JRBeanArrayDataSource(result.toArray()));
        } catch (JRException ex) {
            Logger.getLogger(NoResponseReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
