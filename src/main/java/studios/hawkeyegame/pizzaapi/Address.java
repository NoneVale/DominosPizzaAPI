package studios.hawkeyegame.pizzaapi;

import org.json.JSONArray;
import org.json.JSONObject;
import studios.hawkeyegame.pizzaapi.utils.DominosURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Address {

    private String street;
    private String city;
    private String region;
    private String zipcode;
    private DominosURL.Country country;

    public Address(String street, String city, String zipcode) {
        this(street, city, "", zipcode, "USA");
    }

    public Address(String street, String city, String region, String zipcode, String country) {
        this.street = street.trim();
        this.city = city.trim();
        this.region = region.trim();
        this.zipcode = zipcode.trim();
        this.country = DominosURL.Country.valueOf(country.toUpperCase().trim());
    }

    public String getLineOne() {
        return street;
    }

    public String getLineTwo() {
        return String.format("%s, %s, %s", this.city, this.region, this.zipcode);
    }

    public void getStores() throws IOException {
        URL url = new URL(DominosURL.getStoreFinderUrl(country, DominosURL.URLType.FIND, getLineOne(), getLineTwo(), "Delivery"));
        System.out.println(url.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject object = new JSONObject(response.toString());
        JSONArray stores = object.getJSONArray("Stores");

        for (int i = 0; i < stores.length(); i++) {
            if (!stores.getJSONObject(i).getBoolean("IsOpen")) {
                System.out.println(stores.getJSONObject(i).toString());
                System.out.println();
            }
        }


        //System.out.println(response.toString());
    }
}
