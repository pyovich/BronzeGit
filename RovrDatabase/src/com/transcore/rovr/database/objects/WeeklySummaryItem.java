//=============================================================================
//  Class WeeklySummaryItem - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transcore.rovr.database.objects;

//*****************************************************************************

import java.sql.Timestamp;

// Name: WeeklySummaryItem.java
//
// Project: com.transcore.rovr.database.objects - WeeklySummaryItem
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
// Nov 12, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class WeeklySummaryItem {
    private int weekId;
    private long custDeviceId;
    private Timestamp summaryTime;
    private double distance;
    private long elapsedTime;
    private int accelEvent;
    private int hardBrakeEvent;
    private int speedEvent;
    private long idleTime;
    private int year;
    private Timestamp startTime;
    private Timestamp endTime;
    private String accountName;
    private long deviceId;
    private String deviceName;
    private String imei;
    private long accountId;

    public WeeklySummaryItem() {}

    public WeeklySummaryItem(
            Timestamp startTime, Timestamp endTime, int weekId, 
            long accountId, String accountName, long custDeviceId, 
            String deviceName, String imei, Timestamp summaryTime, 
            double distance, long elapsedTime, int accelEvent, 
            int hardBrakeEvent, int speedEvent, long idleTime) {
        
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekId = weekId;
        
        this.accountId = accountId;
        this.accountName = accountName;
        this.custDeviceId = custDeviceId;
        
        this.deviceName = deviceName;
        this.imei = imei;
        this.summaryTime = summaryTime;
        
        this.distance = distance;
        this.elapsedTime = elapsedTime;
        this.accelEvent = accelEvent;
        
        this.hardBrakeEvent = hardBrakeEvent;
        this.speedEvent = speedEvent;
        this.idleTime = idleTime;
    }

    public int getWeekId() { return weekId; }
    public void setWeekId(int weekId) {this.weekId = weekId; }

    public long getCustDeviceId() {
        return custDeviceId;
    }

    public void setCustDeviceId(long custDeviceId) {
        this.custDeviceId = custDeviceId;
    }

    public Timestamp getSummaryTime() {
        return summaryTime;
    }

    public void setSummaryTime(Timestamp summaryTime) {
        this.summaryTime = summaryTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public int getAccelEvent() {
        return accelEvent;
    }

    public void setAccelEvent(int accelEvent) {
        this.accelEvent = accelEvent;
    }

    public int getHardBrakeEvent() {
        return hardBrakeEvent;
    }

    public void setHardBrakeEvent(int hardBrakeEvent) {
        this.hardBrakeEvent = hardBrakeEvent;
    }

    public int getSpeedEvent() {
        return speedEvent;
    }

    public void setSpeedEvent(int speedEvent) {
        this.speedEvent = speedEvent;
    }

    public long getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(long idleTime) {
        this.idleTime = idleTime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
