package controllers;

//import spiffyUrlManipulator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.css.ElementCSSInlineStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServerController{
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    private ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    public JSONArray idGet(String action) {
        BufferedReader reader = null;
        String line = "";
        StringBuffer responseContent = new StringBuffer();
        JSONParser jsonParser = new JSONParser();
        URL url = null;
        try {
            url = new URL(rootURL + action);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int status = 0;
        try {
            status = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(status);
        JSONArray ids = null;
        if (status > 299) {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (line != null) {
                responseContent.append(line);
            }
        } else {
            try {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                Object obj = jsonParser.parse(reader);
                ids = (JSONArray) obj;
                System.out.println(ids);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //line = reader.readLine();
            while (line != null) {
                responseContent.append(line);
            }
            // url -> /ids/
            // send the server a get with url
            // return json from server
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return ids;
    }
//    public JsonString idPost(Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }
//

}

// ServerController.shared.doGet()