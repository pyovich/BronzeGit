/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.database;

import java.sql.Timestamp;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pyovich
 */
public class StoredProcedureGatewayTest {
    
    public StoredProcedureGatewayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNoActivityData method, of class StoredProcedureGateway.
     */
    @Test
    public void testGetNoActivityData() throws Exception {
        System.out.println("getNoActivityData");
        int accountId = 0;
        int custDeviceId = 0;
        String deviceImei = "";
        Timestamp trxnStartDate = null;
        Timestamp trxnEndDate = null;
        float threshold = 0.0F;
        String timeZone = "";
        int userId = 0;
        int expResult = 0;
        List result = StoredProcedureGateway.getNoActivityData(accountId, custDeviceId, deviceImei, trxnStartDate, trxnEndDate, threshold, timeZone, userId);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEventTrxnTail method, of class StoredProcedureGateway.
     */
    @Test
    public void testGetEventTrxnTail() throws Exception {
        System.out.println("getEventTrxnTail");
        int loginUserId = 0;
        int tranTypeId = 0;
        long acctId = 0L;
        String imei = "";
        long custDeviceId = 0L;
        int custDeviceGroupId = 0;
        int minuteCount = 0;
        int eventCount = 0;
        Timestamp start = null;
        Timestamp end = null;
        String timeCode = "";
        int expResult = 0;
        List result = StoredProcedureGateway.getEventTrxnTail(loginUserId, tranTypeId, acctId, imei, custDeviceId, custDeviceGroupId, minuteCount, eventCount, start, end, timeCode);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of HandleReportResults method, of class StoredProcedureGateway.
     */
    @Test
    public void testHandleReportResults() throws Exception {
        System.out.println("HandleReportResults");
        String reportName = "";
        Timestamp runTime = null;
        String fileName = "";
        int accountId = 0;
        int userId = 0;
        StoredProcedureGateway.HandleReportResults(reportName, runTime, fileName, accountId, userId);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getWeeklySummary method, of class StoredProcedureGateway.
     */
    @Test
    public void testGetWeeklySummary() throws Exception {
        System.out.println("getWeeklySummary");
        int deviceId = 0;
        int accountId = 0;
        Timestamp startDate = null;
        Timestamp endDate = null;
        int userId = 0;
        int expResult = 0;
        List result = StoredProcedureGateway.getWeeklySummary(deviceId, accountId, startDate, endDate, userId);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
