//=============================================================================
//  Class NoResponseItem - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.database.objects;

//*****************************************************************************
import java.io.Serializable;
import java.sql.Timestamp;

// Name: NoResponseItem.java
//
// Project: com.Transcore.Rovr.Database.Objects - NoResponseItem
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
public class NoResponseItem implements Serializable {

    private int accountId;
    private String nextLocation;
    private Float nextLong;
    private Float nextLat;
    private String nextResponse;
    private Timestamp nextResponseTime;
    private Float hoursToNextResponse;
    private Timestamp transactionTime;
    private String location;
    private float longitude;
    private float latitude;
    private String eventTrxnType;
    private int eventTrxnTypeId;
    private int eventTrxnId;
    private String deviceStatus;
    private String deviceName;
    private int deviceId;
    private String imei;
    private int custDeviceId;
    private String accountName;

    //Local fields
    /**
     *
     */
    public NoResponseItem() {
    }

    /**
     *
     * @param accountId
     * @param accountName
     * @param custDeviceId
     * @param imei
     * @param deviceId
     * @param NoResponseItem
     * @param deviceStatus
     * @param eventTrxnId
     * @param eventTrxnTypeId
     * @param eventTrxnType
     * @param latitude
     * @param longitude
     * @param trxnTime
     * @param hoursToNextResponse
     * @param nextResponseTime
     * @param nextResponse
     * @param nextLat
     * @param nextLong
     */
    public NoResponseItem(
            final int accountId, final String accountName, final int custDeviceId,
            final String imei, final int deviceId, final String deviceName,
            final String deviceStatus, final int eventTrxnId, final int eventTrxnTypeId,
            final String eventTrxnType, final float latitude, final float longitude,
            final Timestamp trxnTime, final Float hoursToNextResponse, final Timestamp nextResponseTime,
            final String nextResponse, final Float nextLat, final Float nextLong) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.custDeviceId = custDeviceId;

        this.imei = imei;
        this.deviceId = deviceId;
        this.deviceName = deviceName;

        this.deviceStatus = deviceStatus;
        this.eventTrxnId = eventTrxnId;
        this.eventTrxnTypeId = eventTrxnTypeId;

        this.eventTrxnType = eventTrxnType;
        this.latitude = latitude;
        this.longitude = longitude;

        this.transactionTime = trxnTime;
        this.hoursToNextResponse = hoursToNextResponse;
        this.nextResponseTime = nextResponseTime;

        this.nextResponse = nextResponse;
        this.nextLat = nextLat;
        this.nextLong = nextLong;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNextLocation() {
        return location;
    }

    public void setNextLocation(String location) {
        this.location = location;
    }

    public Float getNextLong() {
        return nextLong;
    }

    public void setNextLong(Float nextLong) {
        this.nextLong = nextLong;
    }

    public Float getNextLat() {
        return nextLat;
    }

    public void setNextLat(Float nextLat) {
        this.nextLat = nextLat;
    }

    public String getNextResponse() {
        return nextResponse;
    }

    public void setNextResponse(String nextResponse) {
        this.nextResponse = nextResponse;
    }

    public Timestamp getNextResponseTime() {
        return nextResponseTime;
    }

    public void setNextResponseTime(Timestamp nextResponseTime) {
        this.nextResponseTime = nextResponseTime;
    }

    public Float getHoursToNextResponse() {
        return hoursToNextResponse;
    }

    public void setHoursToNextResponse(Float hoursToNextResponse) {
        this.hoursToNextResponse = hoursToNextResponse;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getEventTrxnType() {
        return eventTrxnType;
    }

    public void setEventTrxnType(String eventTrxnType) {
        this.eventTrxnType = eventTrxnType;
    }

    public int getEventTrxnTypeId() {
        return eventTrxnTypeId;
    }

    public void setEventTrxnTypeId(int eventTrxnTypeId) {
        this.eventTrxnTypeId = eventTrxnTypeId;
    }

    public int getEventTrxnId() {
        return eventTrxnId;
    }

    public void setEventTrxnId(int eventTrxnId) {
        this.eventTrxnId = eventTrxnId;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String custDeviceDesc) {
        this.deviceName = custDeviceDesc;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getCustDeviceId() {
        return custDeviceId;
    }

    public void setCustDeviceId(int custDeviceId) {
        this.custDeviceId = custDeviceId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
