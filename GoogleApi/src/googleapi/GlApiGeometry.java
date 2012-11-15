/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleapi;

import java.util.List;

/**
 *
 * @author Dave
 */
public class GlApiGeometry {
    
    public GlApiGeometry() {
        
    }
    
    public String noNull(String s)
    {
        if( s == null ){ s = ""; }
        if(s.equalsIgnoreCase(null)){ s = ""; }
        return s;
    }
    
    private GlApiLocation location;
    public GlApiLocation getLocation() { return location; }
    public void setLocation( GlApiLocation l ) { location = l; }
    
    private String location_type = "";
    public String getLocation_type() {return noNull(location_type);}
    public void setLocation_type( String s ) { if(s.equalsIgnoreCase(null)){ s = ""; location_type = s;} }

    private GlApiViewport viewport;
    public GlApiViewport getViewport() { return viewport; }
    public void setViewport( GlApiViewport val ) { viewport = val; }
    
}
