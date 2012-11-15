/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleapi;

/**
 *
 * @author Dave
 */
public class GeoPoint {
    
    public GeoPoint() {
        
    }
    
    public GeoPoint( double lat, double lon ) {
        this.lat = lat;
        this.lon = lon;
    }
    
    private double lat = 0;
    public double getLat() { return lat; }
    public void setLat( double d ) { lat = d; }
    
    private double lon = 0;
    public double getLon() { return lon; }
    public void setLon( double d ) { lon = d; }
        
}
