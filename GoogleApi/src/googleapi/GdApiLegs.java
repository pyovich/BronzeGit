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
public class GdApiLegs {
    
    private GdApiTextValue distance;
    public GdApiTextValue getDistance() { return distance; }
    public void setDistance( GdApiTextValue val ) { distance = val; }
    
    private GdApiTextValue duration;
    public GdApiTextValue getDuration() { return duration; }
    public void setDuration( GdApiTextValue val ) { duration = val; }
    
    private String end_address = "";
    public String getEnd_address() { return end_address; }
    public void setEnd_address( String s ) { end_address = s; } 
    
    private GlApiLocation end_location;
    public GlApiLocation getEnd_location() { return end_location; }
    public void setEnd_location( GlApiLocation val ) { end_location = val; }
    
    private String start_address = "";
    public String getStart_address() { return start_address; }
    public void setStart_address( String s ) { start_address = s; } 
    
    private GlApiLocation start_location;
    public GlApiLocation getStart_location() { return start_location; }
    public void setStart_location( GlApiLocation val ) { start_location = val; }
    
    private List<GdApiSteps> steps;
    public List<GdApiSteps> getSteps() {return steps;}
    public void setSteps( List<GdApiSteps> val ) {steps = val; }
    
    private List<GdApiWaypoint> via_waypoint;
    public List<GdApiWaypoint> getVia_waypoint() { return via_waypoint; }
    public void setVia_waypoint( List<GdApiWaypoint> val ) { via_waypoint = val; }
    
}
