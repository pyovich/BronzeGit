/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.reports;

import com.transcore.rovr.database.StoredProcedureGateway;
import com.transcore.rovr.database.objects.EventTrxnItem;
import com.transcore.rovr.database.objects.EventTrxnItemComparator;
import googleapi.GoogleApi;
import googleapi.MappingCoordinates;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

public class UnpluggedReport extends AbstractReport {

    GoogleApi gapi = new GoogleApi();
    public int userId;
    public int numHours;
    public String timeZone;
    public int accountId;

    @Override
    public void init() {
        String reportPath = "SFOUnplugged.jasper";

        // File the parameters
        Map parameters = new HashMap();
        parameters.put("p_numHours", numHours);

        // Gather the data
        List result1 = getEvents(1);
        List result55 = getEvents(55);
        List result99 = getEvents(99);

        List result = new ArrayList(result1);
        result.addAll(result55);
        result.addAll(result99);

        Collections.sort(result, new EventTrxnItemComparator());

        for (int i = 0; i <= result.size() - 1; i++) {
            EventTrxnItem item = (EventTrxnItem) result.get(i);

            String s = gapi.getGoogleAddress(new MappingCoordinates(
                    (double) item.getLatitude(),
                    (double) item.getLongitude()));
            if (s.isEmpty()) {
                s = "Location could not be found.";
            }
            item.setLocation(s);
            System.out.println(item.getAccountName() + " " + item.getCustomerDeviceDesc() + " " + item.getTransactionTypeId() + " "+ item.getTransactionTime());
       }

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

    private List getEvents(int tranTypeId) {
        List result;
        try {
            int minuteCount = (int) (numHours * 60);
            result = StoredProcedureGateway.getEventTrxnTail(
                    userId, tranTypeId, (long) accountId,
                    "", 0, 0,
                    minuteCount, 0, null, null, timeZone);
        } catch (Exception ex) {
            Logger.getLogger(UnpluggedReport.class.getName()).log(Level.SEVERE, null, ex);
            result = null;
        }
        return result;
    }
}
