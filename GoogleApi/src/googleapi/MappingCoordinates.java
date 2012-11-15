//=============================================================================
//  Class LatLong - TODO: Add Description
//=============================================================================
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package googleapi;

//*****************************************************************************
// Name: LatLong.java
//
// Project: googleapi - LatLong
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
// Nov 1, 2012 -  V1.0 - Created
//
//*****************************************************************************
public class MappingCoordinates {

    private double latitude;
    private double longitude;
    
    public MappingCoordinates(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    double getLatitude() {
        return this.latitude;
    }

    double getLongitude() {
        return this.longitude;
    }

}
