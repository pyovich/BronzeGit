//=============================================================================
//  Class DbUtil - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transcore.rovr.database.utilities;

//*****************************************************************************

import java.sql.ResultSet;
import java.sql.SQLException;

// Name: DbUtil.java
//
// Project: com.Transcore.Rovr.Database.Utiilities - DbUtil
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
// Oct 30, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class DbUtil {

    public static float getFloat(ResultSet resultSet, int i) throws SQLException {
        float fVal;
        fVal = resultSet.getFloat(i);
        if (resultSet.wasNull()) {
            fVal = 0;
        }
        return fVal;
    }
    
    public static int getInt(ResultSet resultSet, int i) throws SQLException {
        int iVal;
        iVal = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            iVal = 0;
        }
        return iVal;
    }
    
    public static double getDouble(ResultSet resultSet, int i) throws SQLException {
        double dVal;
        dVal = resultSet.getDouble(i);
        if (resultSet.wasNull()) {
            dVal = 0;
        }
        return dVal;
    }
    
    public static long getLong(ResultSet resultSet, int i) throws SQLException {
        long lVal;
        lVal = resultSet.getLong(i);
        if (resultSet.wasNull()) {
            lVal = 0;
        }
        return lVal;
    }
    
    public static String getString(ResultSet resultSet, int i) throws SQLException {
        String sVal;
        sVal = resultSet.getString(i);
        if (resultSet.wasNull()) {
            sVal = "";
        }
        return sVal;
    }
}
