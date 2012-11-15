//=============================================================================
//  Class NoResponseReport - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.reports;

//*****************************************************************************
import com.transcore.rovr.database.StoredProcedureGateway;
import com.transcore.rovr.database.objects.EventTrxnItem;
import googleapi.GoogleApi;
import googleapi.MappingCoordinates;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

// Name: NoResponseReport.java
//
// Project: com.Transcore.Rovr.Reports - NoResponseReport
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
// Oct 31, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class NoResponseReport extends AbstractReport {

    String reportFileName = "NoActivity";
    GoogleApi gapi = new GoogleApi();
    public int userId;
    public double threshold;
    public String timeZone;
    public int accountId;

    @Override
    public void init() {

        String reportPath = "SFONoResponse.jasper";

        // File the parameters
        Map parameters = new HashMap();
        parameters.put("p_threshold", threshold);
        
        // Gather the data
        Collection formData = new ArrayList();

        List result;
        try {
            int tranTypeId = 0;

            String imei = "";
            long custDeviceId = 0L;
            int custDeviceGroupId = 0;

            final int minuteCount = 0;
            Timestamp start = null;

            Timestamp end = null;

            result = StoredProcedureGateway.getEventTrxnTail(
                    userId, tranTypeId, accountId,
                    imei, custDeviceId, custDeviceGroupId,
                    minuteCount, 1, start,
                    end, timeZone);
        } catch (Exception ex) {
            result = null;
        }

        Collections.sort(result, new Comparator<EventTrxnItem>() {
            @Override
            public int compare(EventTrxnItem i1, EventTrxnItem i2) {
                return i1.getAccountName().compareTo(i2.getAccountName());
            }
        });

        System.out.println("Total Records found: " + result.size());

        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        System.out.println(now);
        
        List filteredResult = new ArrayList();

        for (int i = 0; i <= result.size() - 1; i++) {
            EventTrxnItem item = (EventTrxnItem) result.get(i);
            
            Long milliseconds = Math.abs(now.getTime() - item.getTransactionTime().getTime());
            
            double elapsedTime = (double)(milliseconds) / (double)(1000 * 60 * 60);
            
            // If this items elapsed time is greater than the threshold then
            // add it to the filtered results, looking up the location along the
            // way
            if (elapsedTime > threshold) {
                String s = gapi.getGoogleAddress(new MappingCoordinates(
                        (double) item.getLatitude(),
                        (double) item.getLongitude()));
                if (s.isEmpty()) {
                    s = "Location could not be found.";
                }
                item.setLocation(s);
                System.out.println(item.getAccountName() + " " + item.getTransactionType() + " " + item.getLatitude() + " " + item.getLongitude());

                filteredResult.add(item);
            }
        }

        // Fill the report
        try {
            jasperPrint = JasperFillManager.fillReport(
                    reportPath,
                    parameters,
                    new JRBeanArrayDataSource(filteredResult.toArray()));
        } catch (JRException ex) {
            Logger.getLogger(NoResponseReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
