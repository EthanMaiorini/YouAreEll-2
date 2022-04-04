package controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private static HashMap<String, Id> allIds = new HashMap<>();

    Id myId;

    public static ArrayList<Id> getIds() throws IOException {

        ServerController serverController = ServerController.shared();
        String getIds = String.valueOf("http://zipcode.rocks:8085/ids");
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Id> ids = new ArrayList<>();
        ids = objectMapper.readValue(new URL("http://zipcode.rocks:8085/ids"),new TypeReference<>(){});
       // ids.addAll(serverController.idGet("/ids"));
       for(Id id : ids){
           allIds.put(id.getGithub(),id);
           //System.out.println(id.toString());
       }
//            System.out.println(id.toString());
//        }
        return ids;
    }

    public Id postId(Id id) {
        id = new Id("Ethan","EthanMaiorini");
        ServerController.shared().idPost(id);
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return id;
    }

    public Id putId(Id id) {
        return null;
    }
 
}