package studios.hawkeyegame.pizzaapi.utils;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class DominosURL {

    public enum Country {
        USA, CANADA
    }

    public enum URLType {
        FIND, INFO, MENU, PLACE_ORDER, PRICE, TRACK_BY_ORDER, TRACK_BY_PHONE, VALIDATE, COUPON
    }

    private static Map<Country, Map<URLType, String>> urls;

    static {
        urls = Maps.newHashMap();

        Map<URLType, String> usaUrls = new HashMap<URLType, String>() {
            {
                put(URLType.FIND, "https://order.dominos.com/power/store-locator?s=%s&c=%s&type=%s");
                put(URLType.INFO, "");
                put(URLType.MENU, "");
                put(URLType.PLACE_ORDER, "");
                put(URLType.PRICE, "");
                put(URLType.TRACK_BY_ORDER, "");
                put(URLType.TRACK_BY_PHONE, "");
                put(URLType.VALIDATE, "");
                put(URLType.COUPON, "");
            }
        };
        urls.put(Country.USA, usaUrls);

        Map<URLType, String> canadaUrls = new HashMap<URLType, String>() {
            {
                put(URLType.FIND, "");
                put(URLType.INFO, "");
                put(URLType.MENU, "");
                put(URLType.PLACE_ORDER, "");
                put(URLType.PRICE, "");
                put(URLType.TRACK_BY_ORDER, "");
                put(URLType.TRACK_BY_PHONE, "");
                put(URLType.VALIDATE, "");
                put(URLType.COUPON, "");
            }
        };
        urls.put(Country.CANADA, canadaUrls);
    }

    public static String getStoreFinderUrl(Country country, URLType type, String line1, String line2, String serviceType) {
        return String.format(urls.get(country).get(type), line1, line2, serviceType).replaceAll(" ", "%20");
    }
}