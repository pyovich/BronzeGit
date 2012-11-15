/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googleapi;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dave
 */
public class GoogleApi {
 
    public void getGoogleDirections( String origin, String dest, String waypoints )
    {
        String httpUrl;

        try
        {
            if( !waypoints.isEmpty() ) {
                httpUrl = "http://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+dest+"&waypoints=optimize:true|"+waypoints+"&sensor=false"; }
            else {
                httpUrl = "http://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+dest+"&sensor=false"; }

            URL url = new URL(httpUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            BufferedReader br =
            new BufferedReader( new InputStreamReader(con.getInputStream(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = br.readLine()) != null;) 
            {
                builder.append(line);
            }
            br.close();
            String data = builder.toString();

            List<String> types;
            routes = new Gson().fromJson( data, GdApiRoutes.class );
        }
        catch( Exception e )
        {
            System.out.println( "<GoogleApi.getGoogleDirections> URL Fetch Error Message: "+e.getMessage() );
        }
        
    }
    
    public List<MappingCoordinates> getRoutePoints()
    {
        String s = routes.getRoutes().get(0).getOverview_polyline().getPoints();
        return decodePoly( s );
    }
    
    private List<MappingCoordinates> decodePoly(String encoded) {

        List<MappingCoordinates> poly = new ArrayList<MappingCoordinates>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            double dblat = (double)lat / 1E5;
            double dblon = (double)lng / 1E5;
            MappingCoordinates p = new MappingCoordinates( dblat, dblon );
            poly.add(p);
        }

        return poly;

    }
    
    public String getGoogleAddress( MappingCoordinates latlon )
    {
        String address = "";
        String httpUrl = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+latlon.getLatitude()+","+latlon.getLongitude()+"&sensor=false";
        try
        {
            URL url = new URL(httpUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            // Dump all the content
            BufferedReader br =
            new BufferedReader( new InputStreamReader(con.getInputStream(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = br.readLine()) != null;) 
            {
                builder.append(line);
            }
            br.close();
            String data = builder.toString();
            int k;

            GlApiResults rslt = new Gson().fromJson( data, GlApiResults.class );
            address = rslt.getResults().get(0).getFormatted_address();

            return address;
        }
        catch( Exception e )
        {
            System.out.println( "<GoogleApi.getGoogleAddress> URL Fetch Error Message: "+e.getMessage() );
        }
        return address;
    }
    
    public MappingCoordinates getGoogleLocation( String address )
    {
        String s = address.replace(" ", "+");
        s = s.replace("/n", "");
        GlApiLocation location;
        double lat;
        double lon;
        MappingCoordinates latLng = new MappingCoordinates( 0.0, 0.0 );
        
        String httpUrl = "http://maps.googleapis.com/maps/api/geocode/json?address="+s+"&sensor=false";
        System.out.println( "----------Opening URL........................."+httpUrl);
        try
        {
            URL url = new URL(httpUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            // Dump all the content
            BufferedReader br =
            new BufferedReader( new InputStreamReader(con.getInputStream(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = br.readLine()) != null;) 
            {
                builder.append(line);
            }
            br.close();
            String data = builder.toString();

            int k;
            System.out.println( "************* Translated JSON Object ***************");
            GlApiResults rslt = new Gson().fromJson( data, GlApiResults.class );
            location = rslt.getResults().get(0).getGeometry().getLocation();
            lat = location.getLat();
            lon = location.getLng();
            latLng = new MappingCoordinates( lat, lon );
            System.out.println( "************* Lat = "+lat+", Lon = "+lon);
            return latLng;
        }
        catch( Exception e )
        {
            System.out.println( "<GoogleApi.getGoogleLocation> URL Fetch Error Message: "+e.getMessage() );
        }
        return latLng;
    }
    
    private GdApiRoutes routes;
    public GdApiRoutes getRoutes() { return routes; }
    public void setRoutes( GdApiRoutes val ){ routes = val; }
}
