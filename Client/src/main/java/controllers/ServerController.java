package controllers;

//import spiffyUrlManipulator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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

    public JSONArray idGet(String action) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new URL(rootURL + action));
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        System.out.println(objectWriter.writeValueAsString(jsonNode));
        return null;
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