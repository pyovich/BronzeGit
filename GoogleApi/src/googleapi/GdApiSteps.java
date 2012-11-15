/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleapi;

/**
 *
 * @author Dave
 */
public class GdApiSteps {
    
    private GdApiTextValue distance;
    public GdApiTextValue getDistance() { return distance; }
    public void setDistance( GdApiTextValue val ) { distance = val; }
    
    private GdApiTextValue duration;
    public GdApiTextValue getDuration() { return duration; }
    public void setDuration( GdApiTextValue val ) { duration = val; }
    
    private GlApiLocation end_location;
    public GlApiLocation getEnd_location() { return end_location; }
    public void setEnd_location( GlApiLocation val ) { end_location = val; }
    
    private String html_instructions = "";
    public String getHtml_instructions() { return html_instructions; }
    public void setHtml_instructions( String s ) { html_instructions = s; } 
    
    private GdApiPolyline polyline;
    public GdApiPolyline getPolyline() { return polyline; }
    public void setPolyline( GdApiPolyline val ) { polyline = val; }
    
    private GlApiLocation start_location;
    public GlApiLocation getStart_location() { return start_location; }
    public void setStart_location( GlApiLocation val ) { start_location = val; }
    
    private String travel_mode = "";
    public String getTravel_mode() { return travel_mode; }
    public void setTravel_mode( String s ) { travel_mode = s; } 
    
}
