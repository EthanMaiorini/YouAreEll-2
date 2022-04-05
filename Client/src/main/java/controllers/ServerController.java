package controllers;

//import spiffyUrlManipulator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Id;
import models.Message;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.css.ElementCSSInlineStyle;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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

    public String idPost(Id id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("http://zipcode.rocks:8085/ids");
        //String out = objectMapper.writeValue(,id);

        // url -> /ids/
        // create json from Id
        // request
        // reply
        // return json
        StringBuilder response = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            String out = objectMapper.writeValueAsString(id);
            OutputStream os = connection.getOutputStream();
            //byte[] input = ;
            os.write(out.getBytes(StandardCharsets.UTF_8));
            int code = connection.getResponseCode();
            System.out.println(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return " ";
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
    }


//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }
public String messagePost(Message message, String sourceId) throws IOException {
    StringBuilder response = null;
    //URL url = new URL(rootURL+"/ids/"+ sourceId + "/messages");
    URL url = new URL("http://zipcode.rocks:8085/ids/EthanMaiorini/messages");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    try {
        //connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        ObjectMapper objectMapper = new ObjectMapper();
        String out = objectMapper.writeValueAsString(message);
        OutputStream os = connection.getOutputStream();
        os.write(out.getBytes(StandardCharsets.UTF_8));
        int code = connection.getResponseCode();
        System.out.println(code);

    } catch (ProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
//
    return " ";
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }
}

}

// ServerController.shared.doGet()