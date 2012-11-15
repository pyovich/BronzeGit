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
public class GdApiRoutesData {
    
    public GdApiRoutesData() {
        
    }
    
    private GdApiBounds bounds;
    public GdApiBounds getBounds() { return bounds; }
    public void setBounds( GdApiBounds val ) { bounds = val; }
    
    private String copyrights = "";
    public String getCopyrights() { return copyrights; }
    public void setCopyrights( String s ) { copyrights = s; } 
    
    private List<GdApiLegs> legs;
    public List<GdApiLegs> getLegs() { return legs; }
    public void setLegs( List<GdApiLegs> val ) { legs = val; }
    
    private GdApiPolyline overview_polyline;
    public GdApiPolyline getOverview_polyline() { return overview_polyline; }
    public void setOverview_polyline( GdApiPolyline val ) { overview_polyline = val; }
    
    private String summary;
    public String getSummary() { return summary; }
    public void setSummary( String s ) { summary = s; }
    
    private List<String> warnings;
    public List<String> getWarnings() {return warnings; }
    public void setWarnings( List<String> val ) { warnings = val; }
    
    private List<Integer> waypoint_order;
    public List<Integer> getWaypoint_order() {return waypoint_order; }
    public void setWaypoint_order( List<Integer> val ) { waypoint_order = val; }
        
}
