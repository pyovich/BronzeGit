//=============================================================================
//  Class CheckNull - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.transcore.rovr.database.utilities;

//*****************************************************************************

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

// Name: CheckNull.java
//
// Project: com.Transcore.Rovr.Database.Utiilities - CheckNull
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
public class CheckNull {
    
    SimpleDateFormat mdy = new SimpleDateFormat( "MM/dd/yyyy" );
    SimpleDateFormat mdyh = new SimpleDateFormat( "MM/dd/yyyy hh:mm:ss");
    
    /** Creates a new instance of DataBaseNullCheck */
    public CheckNull() {
    }
 
    public boolean getBoolean( ResultSet rs, int col )
    {
        boolean val;
        try
        {
           val = rs.getBoolean( col );
           if( rs.wasNull()){ val = false; }
        }
        catch( Exception x )
        {
           val = false;
        }
        return val;
    }
    
    public int getInt( ResultSet rs, int col )
    {
        int val;
        try
        {
           val = rs.getInt( col );
           if( rs.wasNull()){ val = 0; }
        }
        catch( Exception x )
        {
           val = 0;
        }
        return val;
    }
    
    public long getLong( ResultSet rs, int col )
    {
        long val;
        try
        {
           val = rs.getLong( col );
           if( rs.wasNull()){ val = 0; }
        }
        catch( Exception x )
        {
           val = 0;
        }
        return val;
    }
    
    public String getString( ResultSet rs, int col )
    {
        String val;
        try
        {
           val = rs.getString( col ).trim();
           if( rs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }
    
    public double getDouble( String val, double def )
    {
        double d;
        try
        {
            d = Double.parseDouble( val );
        }
        catch( Exception e )
        {
            d = def;
        }
        return d;
    }
    
    public double getDouble( ResultSet rs, int col )
    {
        double val;
        try
        {
           val = rs.getDouble( col );
           if( rs.wasNull()){ val = 0.0; }
        }
        catch( Exception x )
        {
           val = 0;
        }
        return val;
    }
            
    public String getMdyTimestamp( ResultSet rs, int col )
    {
        Timestamp ts;
        String val;
        try
        {
           ts = rs.getTimestamp( col );
           val = mdy.format(ts);
           if( rs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }
        
    public String getMdyhTimestamp( ResultSet rs, int col )
    {
        Timestamp ts;
        String val;
        try
        {
           ts = rs.getTimestamp( col );
           val = mdyh.format(ts);
           if( rs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }
        
    public Date getDate( ResultSet rs, int col )
    {
        Date ts;
        String val = "";
        try
        {
           ts = rs.getDate( col );
        }
        catch( Exception x )
        {
           ts = null;
        }
        return ts;
    }

    public String getMdyDate( ResultSet rs, int col )
    {
        Timestamp ts;
        String val;
        try
        {
           ts = rs.getTimestamp( col );
           val = mdy.format(ts);
           if( rs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }

    public String getMdyDateTime( ResultSet rs, int col )
    {
        Timestamp ts;
        String val;
        try
        {
           ts = rs.getTimestamp( col );
           val = mdyh.format(ts);
           if( rs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }

    public int getInt( CallableStatement cs, int col )
    {
        int val;
        try
        {
           val = cs.getInt( col );
           if( cs.wasNull()){ val = 0; }
        }
        catch( Exception x )
        {
           val = 0;
        }
        return val;
    }

    public long getLong( CallableStatement cs, int col )
    {
        long val;
        try
        {
           val = cs.getLong( col );
           if( cs.wasNull()){ val = 0; }
        }
        catch( Exception x )
        {
           val = 0;
        }
        return val;
    }

    public String getString( CallableStatement cs, int col )
    {
        String val;
        try
        {
           val = cs.getString( col ).trim();
           if( cs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }

    public double getDouble( CallableStatement cs, int col )
    {
        double val;
        try
        {
           val = cs.getDouble( col );
           if( cs.wasNull()){ val = 0.0; }
        }
        catch( Exception x )
        {
           val = 0;
        }
        return val;
    }

    public String getMdyTimestamp( CallableStatement cs, int col )
    {
        Timestamp ts;
        String val;
        try
        {
           ts = cs.getTimestamp( col );
           val = mdy.format(ts);
           if( cs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }

    public String getMdyDate( CallableStatement cs, int col )
    {
        Timestamp ts;
        String val;
        try
        {
           ts = cs.getTimestamp( col );
           val = mdy.format(ts);
           if( cs.wasNull()){ val = ""; }
        }
        catch( Exception x )
        {
           val = "";
        }
        return val;
    }
}
