package id.net.gmedia.paloutletlocator.Utils;

/**
 * Created by Shinmaul on 10/9/2017.
 */

public class ServerURL {

    //private static final String baseURL = "http://192.168.17.4/perkasamobile/pol/";
    //private static final String baseURL = "http://36.66.177.165/pol/";
    private static final String baseURL = "http://gmedia.bz/pal/apipol/";

    public static final String login = baseURL + "location/login/";
    public static final String getLocation = baseURL + "location/get_location/";
    public static final String saveLocation = baseURL + "location/save_location/";
    public static final String saveImages = baseURL + "location/insert_foto/";
    public static final String getImages = baseURL + "location/get_images/";
}
