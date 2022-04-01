package youareell;

import controllers.*;
import models.Id;

import java.io.IOException;
import java.util.ArrayList;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public static void main(String[] args) throws IOException {

        ServerController serverController = ServerController.shared();
        //serverController.idGet("/ids");
        serverController.idGet("/messages");
//        ArrayList<Id> idc = IdController.getIds();
//        for(Id id : idc){
//           System.out.println(id.toString());
//      }
        // hmm: is this Dependency Injection?
//        YouAreEll urlhandler = new YouAreEll(
//            new TransactionController(new MessageController(), new IdController()));
//        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
//        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

//    public String get_ids() {
//        return tt.makecall("/ids", "GET", "");
//    }
//
//    public String get_messages() {
//        return MakeURLCall("/messages", "GET", "");
//    }
//

}
