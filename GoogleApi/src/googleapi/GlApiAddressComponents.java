/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleapi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dave
 */
public class GlApiAddressComponents {
    
    public GlApiAddressComponents() {
        
    }
    
    public String noNull(String s)
    {
        if( s == null ){ s = ""; }
        if(s.equalsIgnoreCase(null)){ s = ""; }
        return s;
    }
    
    private String long_name = "";
    public String getLong_name() {return noNull(long_name);}
    public void setLong_name( String s ) { if(s.equalsIgnoreCase(null)){ s = ""; long_name = s;} } 
    
    private String short_name = "";
    public String getShort_name() {return noNull(short_name);}
    public void setShort_name( String s ) { if(s.equalsIgnoreCase(null)){ s = ""; short_name = s;} }
    
    private List<String> types = new ArrayList<String>(); 
    public List<String> getTypes() {return types; }
    public void setTypes( List<String> val ) { types = val; }
    
    
}
