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
public class GlApiResultsData {
    
    public GlApiResultsData() {
        
    }
    
    private List<GlApiAddressComponents> address_components;
    public List<GlApiAddressComponents> getAddress_components() { return address_components; }
    public void setAddress_components( List<GlApiAddressComponents> val ) { address_components = val; }
    
    private String formatted_address;
    public String getFormatted_address() { return formatted_address; }
    public void setFormatted_address( String s ) { formatted_address = s; }
    
    private GlApiGeometry geometry;
    public GlApiGeometry getGeometry() { return geometry; }
    public void setGeometry( GlApiGeometry val ) { geometry = val; }
    
    List<String> types;
    public List<String> getTypes() {return types; }
    public void setTypes( List<String> val ) { types = val; }
    
}
