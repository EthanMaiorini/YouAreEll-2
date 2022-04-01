package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import models.Id;

public class IdController {
    private HashMap<String, Id> allIds;

    Id myId;

    public static ArrayList<Id> getIds() {
        ArrayList<Id> ids = new ArrayList<>();
        ServerController serverController = ServerController.shared();
        ids.addAll(serverController.idGet("/ids"));
//        for(Id id : ids){
//            System.out.println(id.toString());
//        }
        return ids;
    }

    public Id postId(Id id) {
        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}