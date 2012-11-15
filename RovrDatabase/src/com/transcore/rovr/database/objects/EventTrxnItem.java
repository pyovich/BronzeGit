//=============================================================================
//  Class EventTrxnItem - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transcore.rovr.database.objects;

//*****************************************************************************
import java.sql.Timestamp;
import java.util.Comparator;

// Name: EventTrxnItem.java
//
// Project: com.Transcore.Rovr.Database - EventTrxnItem
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
// Nov 2, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class EventTrxnItem {

    private int itemId;
    private String location;
    private String imei;
    private Timestamp transactionTime;
    private Timestamp postTime;
    private long accountId;
    private int accountAccessLevel;
    private long custDeviceId;
    private int deviceAccessLevel;
    private int messageTypeId;
    private String messageType;
    private String accountName;
    private String customerDeviceDesc;
    private int transactionTypeId;
    private String transactionType;
    private String geoFence;
    private String polygonName;
    private int polygonTypeId;
    private String polygonType;
    private int bearing;
    private double latitude;
    private double longitude;
    private int transactionId;
    private String transitCode;
    private int eventCountPerDevice;

    public void setImei(String value) {
        this.imei = value;
    }

    public void setTranTime(Timestamp value) {
        this.transactionTime = value;
    }

    public void setPostTime(Timestamp value) {
        this.postTime = value;
    }

    public void setAcctId(long value) {
        this.accountId = value;
    }

    public void setAcctAccessLevel(int value) {
        this.accountAccessLevel = value;
    }

    public void setCustDeviceId(long value) {
        this.custDeviceId = value;
    }

    public void setDeviceAccessLevel(int value) {
        this.deviceAccessLevel = value;
    }

    public void setMessageTypeId(int value) {
        this.messageTypeId = value;
    }

    public void setMessageType(String value) {
        this.messageType = value;
    }

    public void setAcctName(String value) {
        this.accountName = value;
    }

    public void setCustDeviceDesc(String value) {
        this.customerDeviceDesc = value;
    }

    public void setTranTypeId(int value) {
        this.transactionTypeId = value;
    }

    public void setTranType(String value) {
        this.transactionType = value;
    }

    public void setGeoFence(String value) {
        this.geoFence = value;
    }

    public void setPolygonName(String value) {
        this.polygonName = value;
    }

    public void setPolygonTypeId(int value) {
        this.polygonTypeId = value;
    }

    public void setPolyType(String value) {
        this.polygonType = value;
    }

    public void setBearing(int value) {
        this.bearing = value;
    }

    public void setLatitude(double value) {
        this.latitude = value;
    }

    public void setLongitude(double value) {
        this.longitude = value;
    }

    public void setTranId(int value) {
        this.transactionId = value;
    }

    public void setTransitCode(String value) {
        this.transitCode = value;
    }

    public void setEventCountPerDevice(int value) {
        this.eventCountPerDevice = value;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setItemId(int aInt) {
        this.itemId = aInt;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getLocation() {
        return location;
    }

    public String getImei() {
        return imei;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public long getAccountId() {
        return accountId;
    }

    public int getAccountAccessLevel() {
        return accountAccessLevel;
    }

    public long getCustDeviceId() {
        return custDeviceId;
    }

    public int getDeviceAccessLevel() {
        return deviceAccessLevel;
    }

    public int getMessageTypeId() {
        return messageTypeId;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getCustomerDeviceDesc() {
        return customerDeviceDesc;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getGeoFence() {
        return geoFence;
    }

    public String getPolygonName() {
        return polygonName;
    }

    public int getPolygonTypeId() {
        return polygonTypeId;
    }

    public String getPolygonType() {
        return polygonType;
    }

    public int getBearing() {
        return bearing;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getTransitCode() {
        return transitCode;
    }

    public int getEventCountPerDevice() {
        return eventCountPerDevice;
    }
    
    public static final Comparator<EventTrxnItem> ACCOUNT_NAME_ORDER =
            new Comparator<EventTrxnItem>() {
                public int compare(EventTrxnItem e1, EventTrxnItem e2) {
                    return e1.accountName.compareTo(e2.accountName);
                }
            };
    
    public static final Comparator<EventTrxnItem> DEVICE_NAME_ORDER =
            new Comparator<EventTrxnItem>() {
                public int compare(EventTrxnItem e1, EventTrxnItem e2) {
                    return e1.customerDeviceDesc.compareTo(e2.customerDeviceDesc);
                }
            };
    
    public static final Comparator<EventTrxnItem> TRXN_DATE_ORDER =
            new Comparator<EventTrxnItem>() {
                public int compare(EventTrxnItem e1, EventTrxnItem e2) {
                    return e1.transactionTime.compareTo(e2.transactionTime);
                }
            };
}
