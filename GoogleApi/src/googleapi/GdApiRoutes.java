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
public class GdApiRoutes {
    
    public GdApiRoutes() {
        
    }
    
    public String noNull(String s)
    {
        if( s == null ){ s = ""; }
        if(s.equalsIgnoreCase(null)){ s = ""; }
        return s;
    }
    
    private List<GdApiRoutesData> routes;
    public List<GdApiRoutesData> getRoutes() { return routes; }
    public void setRoutes( List<GdApiRoutesData> val ) { routes = val; }
    
    private String status;
    public String getStatus() { return status; }
    public void setStatus( String s ) { status = s; }
        
}
