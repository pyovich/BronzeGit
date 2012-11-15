/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.database.objects;

import java.util.Comparator;

/**
 *
 * @author Peter
 */

public class EventTrxnItemComparator implements Comparator<EventTrxnItem> {
    public int compare(EventTrxnItem o1, EventTrxnItem o2) {
        //First sort by Account name
        int accountResult = o1.getAccountName().compareTo(o2.getAccountName());
        if (accountResult != 0 ) {
            return accountResult;
        }
        
        //Now by device name
        int deviceResult = o1.getCustomerDeviceDesc().compareTo(o2.getCustomerDeviceDesc());
        if (deviceResult != 0 ) {
            return deviceResult;
        }
        
        // Lastly by event date
        return o1.getTransactionTime().compareTo(o2.getTransactionTime());
    }
}