//=============================================================================
//  Class NoActivityRepositoryImpl - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.database;

//*****************************************************************************
import com.transcore.rovr.database.objects.*;
import com.transcore.rovr.database.utilities.DbUtil;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Name: NoActivityRepositoryImpl.java
//
// Project: com.Transcore.Rovr.Database - NoActivityRepositoryImpl
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
// Oct 29, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class StoredProcedureGateway {

    static Connection connection = null;
    static CallableStatement cs = null;
    static ResultSet resultSet = null;
    static private int returnCode;
    static private String status;

    public StoredProcedureGateway() {
    }

    private static void getConnection() throws SQLException {
        connection = DatabaseConnectionFactory.getInstance().getConnection();
    }

    /**
     *
     * @param accountId
     * @param custDeviceId
     * @param deviceImei
     * @param trxnStartDate
     * @param trxnEndDate
     * @param threshold
     * @param timeZone
     * @param userId
     * @return
     * @throws SQLException
     */
    public static List getNoActivityData(
            int accountId,
            int custDeviceId,
            String deviceImei,
            Timestamp trxnStartDate,
            Timestamp trxnEndDate,
            float threshold,
            String timeZone,
            int userId) throws SQLException {

        log(Level.INFO, "<NoActivityRepository.getNoActivityData>START...");
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>    accountId = " + accountId);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData> custDeviceId = " + custDeviceId);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>   deviceImei = " + deviceImei);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>    startDate = " + trxnStartDate);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>      endDate = " + trxnEndDate);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>    threshold = " + threshold);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>     timezone = " + timeZone);
        log(Level.INFO, "<NoActivityRepository.getNoActivityData>       userId = " + userId);

        List<NoResponseItem> results = new ArrayList<NoResponseItem>();
        getConnection();

        String guery = "{ call uspGetNoActivity( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        try {
            cs = connection.prepareCall(guery);

            //TODO:  Add null checks
            cs.setInt(1, accountId);
            cs.setInt(2, custDeviceId);
            cs.setString(3, deviceImei);
            cs.setTimestamp(4, trxnStartDate);
            cs.setTimestamp(5, trxnEndDate);
            cs.setFloat(6, threshold);
            cs.setString(7, timeZone);
            cs.setInt(8, userId);
            cs.registerOutParameter(9, java.sql.Types.INTEGER);
            cs.registerOutParameter(10, java.sql.Types.VARCHAR);

            cs.executeQuery();
            resultSet = cs.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {
                    NoResponseItem newItem = new NoResponseItem();

                    newItem.setAccountId(resultSet.getInt(1));
                    newItem.setAccountName(resultSet.getString(2));
                    newItem.setCustDeviceId(resultSet.getInt(3));

                    newItem.setImei(resultSet.getString(4));
                    newItem.setDeviceId(resultSet.getInt(5));
                    newItem.setDeviceName(resultSet.getString(6));

                    newItem.setDeviceStatus(resultSet.getString(7));
                    newItem.setEventTrxnId(resultSet.getInt(8));
                    newItem.setEventTrxnTypeId(resultSet.getInt(9));

                    newItem.setEventTrxnType(resultSet.getString(10));
                    newItem.setLatitude(DbUtil.getFloat(resultSet, 11));
                    newItem.setLongitude(DbUtil.getFloat(resultSet, 12));

                    newItem.setTransactionTime(resultSet.getTimestamp(13));
                    newItem.setHoursToNextResponse(DbUtil.getFloat(resultSet, 14));
                    newItem.setNextResponseTime(resultSet.getTimestamp(15));

                    newItem.setNextResponse(resultSet.getString(16));
                    newItem.setNextLat(DbUtil.getFloat(resultSet, 17));
                    newItem.setNextLong(DbUtil.getFloat(resultSet, 18));

                    newItem.setLocation("");
                    newItem.setNextLocation("");

                    results.add(newItem);
                    System.out.println(results.size());
                }
            }

            returnCode = cs.getInt(9);
            status = cs.getString(10);

            log(Level.INFO, "<getNoActivityData> ===Return code = " + returnCode);
            log(Level.INFO, "<getNoActivityData> ===Return msg = " + status);

        } catch (Exception e) {
            log(Level.INFO, "<getNoActivityData> Database Error: " + e.getMessage(), e);
        }

        log(Level.INFO, "<getNoActivityData>...END");

        if (!connection.isClosed()) {
            connection.close();
        }

        return results;
    }

    /**
     * @param loginUserId
     * @param tranTypeId
     * @param acctId
     * @param imei
     * @param custDeviceId
     * @param custDeviceGroupId
     * @param minuteCount
     * @param eventCount
     * @param start
     * @param end
     * @param timeCode
     * @return
     * @throws SQLException
     */
    public static List getEventTrxnTail(
            int loginUserId,
            int tranTypeId,
            long acctId,
            String imei,
            long custDeviceId,
            int custDeviceGroupId,
            int minuteCount,
            int eventCount,
            Timestamp start,
            Timestamp end,
            String timeCode) throws SQLException {
        log(Level.INFO, "============<DatabaseSessionBean.getEventTrxnTail> UserId = " + loginUserId + ", TranTypeId = " + tranTypeId
                + ", AccountId = " + acctId + ", IMEI = " + imei + ", Cust Device Id = " + custDeviceId + ", CustDeviceGroupId = " + custDeviceGroupId + ", MinuteCount = " + minuteCount
                + ", Event Count = " + eventCount + ", Time Zone = " + timeCode);
        getConnection();
        CallableStatement cs;
        ResultSet rs;
        int retCode;

        List<EventTrxnItem> results = new ArrayList<EventTrxnItem>();

// uspGetEventTrxnTail parameters
//	@ipv_iEventTrxnTypeId	TINYINT,
//	@ipv_biAccountId	BIGINT,
//	@ipv_vcIMEI		VARCHAR(20),
//	@ipv_biCustDeviceId	BIGINT,
//	@ipv_iCustDeviceGroupId	INT,
//	@ipv_iLastNbrOfMinutes	INT,
//	@ipv_iLastNbrOfEvents	INT,
//	@ipv_dtStartTime	DATETIME,
//	@ipv_dtEndTime		DATETIME,
//	@ipv_vcTimeZoneCode	VARCHAR(6),
//	@ipv_iUserId		INT,
//	@opv_iRtnCode		INTEGER OUT,
//	@opv_vcRtnMsg		VARCHAR(1000) OUT
//)
        String query = "{ call uspGetEventTrxnTail( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?  ) }";
        try {
            cs = connection.prepareCall(query);
            cs.setInt(1, tranTypeId);
            cs.setLong(2, acctId);
            cs.setString(3, imei);
            cs.setLong(4, custDeviceId);
            cs.setInt(5, custDeviceGroupId);
            cs.setInt(6, minuteCount);
            cs.setInt(7, eventCount);
            cs.setTimestamp(8, start);
            cs.setTimestamp(9, end);
            cs.setString(10, timeCode);
            if (timeCode.isEmpty()) {
                cs.setNull(10, java.sql.Types.NULL);
            }
            cs.setInt(11, loginUserId);
            cs.registerOutParameter(12, java.sql.Types.INTEGER);
            cs.registerOutParameter(13, java.sql.Types.VARCHAR);

            cs.execute();
            rs = cs.getResultSet();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    EventTrxnItem evt = new EventTrxnItem();
                    evt.setItemId(DbUtil.getInt(rs, 1));
                    log(Level.INFO, "<getEventTrxnTail> in rs.next() index = " + i + ", Transaction id =  " + evt.getItemId());
                    evt.setAcctId(DbUtil.getLong(rs, 2));
                    evt.setAcctAccessLevel(DbUtil.getInt(rs, 3));
                    evt.setAcctName(DbUtil.getString(rs, 4));
                    evt.setCustDeviceId(DbUtil.getLong(rs, 5));
                    evt.setDeviceAccessLevel(DbUtil.getInt(rs, 6));
                    evt.setCustDeviceDesc(DbUtil.getString(rs, 7));
                    evt.setImei(DbUtil.getString(rs, 8));
                    evt.setTranTime(rs.getTimestamp(9));
                    evt.setPostTime(rs.getTimestamp(10));
                    evt.setMessageTypeId(DbUtil.getInt(rs, 11));
                    evt.setMessageType(DbUtil.getString(rs, 12));
                    evt.setTranTypeId(DbUtil.getInt(rs, 13));
                    evt.setTranType(DbUtil.getString(rs, 14));
                    evt.setGeoFence(DbUtil.getString(rs, 15));
                    evt.setPolygonName(DbUtil.getString(rs, 16));
                    evt.setPolygonTypeId(DbUtil.getInt(rs, 17));
                    evt.setPolyType(DbUtil.getString(rs, 18));
                    evt.setLatitude(DbUtil.getDouble(rs, 19));
                    evt.setLongitude(DbUtil.getDouble(rs, 20));
                    evt.setBearing(DbUtil.getInt(rs, 21));
                    evt.setTranId(DbUtil.getInt(rs, 22));
                    evt.setTransitCode(DbUtil.getString(rs, 23));
                    evt.setEventCountPerDevice(DbUtil.getInt(rs, 24));
                    evt.setLocation("location");
                    results.add(evt);
                    i++;
                }
            }
            retCode = cs.getInt(12);
            status = cs.getString(13);
            log(Level.INFO, "============= <getEventTrxnTail> Return code = " + retCode);
            log(Level.INFO, "============= <getEventTrxnTail> Return msg = " + status);
            if (retCode != 0) {
                log(Level.INFO, "Error Fetching Event Transactions: " + status);
            }
        } catch (Exception e) {
            log(Level.WARNING, "<getEventTrxnTail> Database Error: " + e.getMessage(), e);
        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }

        return results;
    }

    public static void HandleReportResults(String reportName, Timestamp runTime,
            String fileName, int accountId, int userId) throws SQLException {
        getConnection();

        log(Level.INFO, "<handleReportResults> reportName = " + reportName);
        log(Level.INFO, "<handleReportResults>    runTime = " + runTime);
        log(Level.INFO, "<handleReportResults>   fileName = " + fileName);
        log(Level.INFO, "<handleReportResults>  accountId = " + accountId);
        log(Level.INFO, "<handleReportResults>     userId = " + userId);

        String query = "{ call uspHandleReportResult( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }";
        try {
            cs = connection.prepareCall(query);

            cs.registerOutParameter(1, java.sql.Types.INTEGER); // @iReportResultId
            cs.setString(2, reportName);                        // @vcReportName
            cs.setTimestamp(3, runTime);                        // @dtRunTime

            cs.setString(4, fileName);                          // @vcFileName
            cs.setInt(5, accountId);                            // @biAccountId
            cs.setTimestamp(6, null);                           // @dtMessageDeliveredTime

            cs.setString(7, "I");                               // @vcUpdType
            cs.setInt(8, userId);                               // @iUpdUserId
            cs.registerOutParameter(9, java.sql.Types.INTEGER);
            cs.registerOutParameter(10, java.sql.Types.VARCHAR);

            cs.execute();

            int resultId = cs.getInt(1);
            returnCode = cs.getInt(9);
            status = cs.getString(10);

            log(Level.INFO, "============= <handleReportResults> Return code = " + returnCode);
            log(Level.INFO, "============= <handleReportResults> Return msg = " + status);

            if (resultId != 0) {
                log(Level.INFO, "Error Handling Report Results: " + status);
            }

        } catch (Exception ex) {
            log(Level.WARNING, "<HandleReportResults> Database Error: " + ex.getMessage(), ex);
        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    public static List getWeeklySummary(
            int deviceId,
            int accountId,
            Timestamp startDate,
            Timestamp endDate,
            int userId) throws SQLException {
        log(Level.INFO, "<getWeeklySummary> START...");
        log(Level.INFO, "<getWeeklySummary>    accountId = " + accountId);
        log(Level.INFO, "<getWeeklySummary> custDeviceId = " + deviceId);
        log(Level.INFO, "<getWeeklySummary>    startDate = " + startDate);
        log(Level.INFO, "<getWeeklySummary>      endDate = " + endDate);
        log(Level.INFO, "<getWeeklySummary>       userId = " + userId);

        getConnection();
        CallableStatement cs;
        ResultSet rs;
        int retCode;

        List<WeeklySummaryItem> results = new ArrayList<WeeklySummaryItem>();

        String query = "{ call [uspGetWeeklySummary]( ?, ?, ?, ?, ?, ?, ? ) }";
        try {
            cs = connection.prepareCall(query);
            cs.setLong(1, deviceId);
            cs.setLong(2, accountId);
            cs.setTimestamp(3, startDate);
            cs.setTimestamp(4, endDate);
            cs.setInt(5, userId);
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.registerOutParameter(7, java.sql.Types.VARCHAR);

            cs.execute();
            rs = cs.getResultSet();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    WeeklySummaryItem item = new WeeklySummaryItem();
                    
                    item.setStartTime(rs.getTimestamp(1));
                    item.setEndTime(rs.getTimestamp(2));
                    item.setWeekId(DbUtil.getInt(rs, 3));
                    
                    item.setAccountId(DbUtil.getLong(rs,4));
                    item.setAccountName(DbUtil.getString(rs, 5));
                    item.setDeviceId(DbUtil.getLong(rs, 6));
                    
                    item.setDeviceName(DbUtil.getString(rs,7));
                    item.setImei(DbUtil.getString(rs,8));
                    item.setSummaryTime(rs.getTimestamp(9));
                    
                    item.setDistance(DbUtil.getDouble(rs, 10));
                    item.setElapsedTime(DbUtil.getLong(rs, 11));
                    item.setHardBrakeEvent(DbUtil.getInt(rs,12));
                    
                    item.setAccelEvent(DbUtil.getInt(rs,13));
                    item.setSpeedEvent(DbUtil.getInt(rs,14));
                    item.setIdleTime(DbUtil.getLong(rs,15));
                                      
                    results.add(item);
                    i++;
                }
            }
            retCode = cs.getInt(16);
            status = cs.getString(17);
            log(Level.INFO, "============= <getWeeklySummary> Return code = " + retCode);
            log(Level.INFO, "============= <getWeeklySummary> Return msg = " + status);
            if (retCode != 0) {
                log(Level.INFO, "Error Fetching WeeklySummary: " + status);
            }
        } catch (Exception e) {
            log(Level.WARNING, "<getWeeklySummary> Database Error: " + e.getMessage(), e);
        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
        return results;
    }
    
    public static List getWeeklySummary_STUB(
            int deviceId,
            int accountId,
            Timestamp startDate,
            Timestamp endDate,
            int userId) throws SQLException {
        log(Level.INFO, "<getWeeklySummary> START...");
        log(Level.INFO, "<getWeeklySummary>    accountId = " + accountId);
        log(Level.INFO, "<getWeeklySummary> custDeviceId = " + deviceId);
        log(Level.INFO, "<getWeeklySummary>    startDate = " + startDate);
        log(Level.INFO, "<getWeeklySummary>      endDate = " + endDate);
        log(Level.INFO, "<getWeeklySummary>       userId = " + userId);
        List results = new ArrayList<WeeklySummaryItem>();
        
        java.util.Date date = new java.util.Date();
        
        results.add(new WeeklySummaryItem(
                new Timestamp(date.getTime()), new Timestamp(date.getTime()), 1,
                8675309, "Stub Account", 369, 
                "Device 1 Name", "123456789012345", new Timestamp(date.getTime()), 
                10, 120, 1, 2, 3, 40));
        
        results.add(new WeeklySummaryItem(
                new Timestamp(date.getTime()), new Timestamp(date.getTime()), 1,
                8675309, "Stub Account", 693, 
                "Device 2 Name", "123456789012345", new Timestamp(date.getTime()), 
                10, 120, 1, 2, 3, 40));
        
        results.add(new WeeklySummaryItem(
                new Timestamp(date.getTime()), new Timestamp(date.getTime()), 1,
                8675309, "Stub Account", 936, 
                "Device 3 Name", "123456789012345", new Timestamp(date.getTime()), 
                10, 120, 1, 2, 3, 40));
        
        return results;
    }

    private static void log(Level level, String message) {
        Logger.getLogger(DatabaseConnectionFactory.class.getName()).log(
                level, message);
        System.out.println(message);
    }

    private static void log(Level level, String message, Exception e) {
        Logger.getLogger(DatabaseConnectionFactory.class.getName()).log(
                level, message, e);
        System.out.println(message);
        System.out.println(e.toString());
    }
}
