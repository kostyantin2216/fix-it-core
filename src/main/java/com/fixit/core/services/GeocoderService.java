/**
 * 
 */
package com.fixit.core.services;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fixit.core.data.Address;
import com.fixit.core.data.MutableLatLng;
import com.fixit.core.data.MutableLatLngBounds;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 18:40:20 GMT+2
 */
public class GeocoderService {
	
	private final static Gson gson = new Gson();
	private final static int MAX_RETRIES = 5;
	private final static int RETRY_INTERVAL_MILLIS = 1000;
	
	public static Optional<Address> getAddress(String address) throws IOException {	
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        
		String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s",
                URLEncoder.encode(address, "utf-8"));

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        GeocodeResponse geocodeResponse = parseAddress(httpClient, request, address, 0);
        
        if(geocodeResponse.status.equals("OK")) {
            for(GeocodeResult result : geocodeResponse.results) {
                if(result.types.contains("street_address") || result.types.contains("route")) {
                    return Optional.of(result.extractAddress());
                }
            }
        }
        return Optional.empty();
	}
	
	 private static GeocodeResponse parseAddress(OkHttpClient httpClient, Request request, String address, int retries) throws IOException {
         Response response = httpClient.newCall(request).execute();

         GeocodeResponse geocodeResponse = gson.fromJson(response.body().charStream(), GeocodeResponse.class);

         if(geocodeResponse.status.equals("OVER_QUERY_LIMIT") && retries < MAX_RETRIES) {
             try {
                 Thread.sleep(RETRY_INTERVAL_MILLIS);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             geocodeResponse = parseAddress(httpClient, request, address, ++retries);
         }

         return geocodeResponse;
     }
	
	private static class GeocodeResponse {
	    List<GeocodeResult> results;
	    String status;
	}

	private static class GeocodeResult {
	    List<AddressComponent> address_components;
	    String formatted_address;
	    GeocodeGeometry geometry;
	    Boolean partial_match;
	    String place_id;
	    List<String> types;
	    
	    Address extractAddress() {
	    	Address address = new Address();
	    	Map<AddressComponent.Type, AddressComponent> addressComponentsByType = AddressComponent.sortByType(address_components);
            for (Map.Entry<AddressComponent.Type, AddressComponent> addressComponentForType : addressComponentsByType.entrySet()) {
                AddressComponent addressComponent = addressComponentForType.getValue();
                switch (addressComponentForType.getKey()) {
                    case street_number:
                        address.setSubThoroughfare(addressComponent.long_name);
                        break;
                    case route:
                        address.setThoroughfare(addressComponent.long_name);
                        break;
                    case sublocality:
                        address.setSubLocality(addressComponent.long_name);
                        break;
                    case locality:
                        address.setLocality(addressComponent.long_name);
                        break;
                    case administrative_area_level_1:
                        address.setAdminArea(addressComponent.long_name);
                        break;
                    case postal_code:
                        address.setPostalCode(addressComponent.long_name);
                        break;
                    case country:
                    	address.setCountryName(addressComponent.long_name);
                        break;
                }
            }

            address.setAddressLine(formatted_address);

            address.setLatitude(geometry.location.getLat());
            address.setLongitude(geometry.location.getLng());
            
            return address;
	    }
	}

	private static class GeocodeGeometry {
	    MutableLatLngBounds bounds;
	    MutableLatLng location;
	    String locationType;
	    MutableLatLngBounds viewport;
	}
	
	private static class AddressComponent {
	    enum Type {
	        street_number,
	        route,
	        sublocality,
	        locality,
	        administrative_area_level_1,
	        country,
	        postal_code;

	        static Type find(String name) {
	            switch (name) {
	                case "street_number":
	                    return street_number;
	                case "route":
	                    return route;
	                case "sublocality":
	                    return sublocality;
	                case "locality":
	                    return locality;
	                case "administrative_area_level_1":
	                    return administrative_area_level_1;
	                case "country":
	                    return country;
	                case "postal_code":
	                    return postal_code;
	                default:
	                    return null;
	            }
	        }
	    }

	    String long_name;
	    String short_name;
	    List<String> types;

	    static Map<Type, AddressComponent> sortByType(List<AddressComponent> addressComponents) {
	        Map<Type, AddressComponent> sorted = new HashMap<>();
	        for (AddressComponent component : addressComponents) {
	            for (String componentType : component.types) {
	                Type type = Type.find(componentType);
	                if (type != null) {
	                    sorted.put(type, component);
	                }
	            }
	        }
	        return sorted;
	    }
	}
}
