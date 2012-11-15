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
public class GdPolylinePointDecoder {

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
//            GeoPoint p = new GeoPoint((int) (((double) lat / 1E5) * 1E6),
//                    (int) (((double) lng / 1E5) * 1E6));
            System.out.println("lat = " + lat + ", lng = " + lng+", dbLat = "+dblat+", dblon = "+dblon );
            poly.add(p);
        }

        return poly;

    }
}
