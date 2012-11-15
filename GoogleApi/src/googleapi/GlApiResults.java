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
public class GlApiResults {
    
    public GlApiResults() {
        
    }
    
    public String noNull(String s)
    {
        if( s == null ){ s = ""; }
        if(s.equalsIgnoreCase(null)){ s = ""; }
        return s;
    }
    
    private List<GlApiResultsData> results;
    public List<GlApiResultsData> getResults() { return results; }
    public void setResults( List<GlApiResultsData> val ) { results = val; }
    
    private String status;
    public String getStatus() { return status; }
    public void setStatus( String s ) { status = s; }
        
}
