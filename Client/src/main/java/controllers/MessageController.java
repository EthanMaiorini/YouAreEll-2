package controllers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen = new HashSet<Message>();
    private final ServerController serverController = ServerController.shared();
    // why a HashSet??

    public ArrayList<Message> getMessages() throws IOException {
        //String messageString = String.valueOf(serverController.get());
        ObjectMapper objectMapper = new ObjectMapper();
        messagesSeen = objectMapper.readValue(new URL("http://zipcode.rocks:8085/messages"),new TypeReference<>(){});
        messagesSeen.forEach(System.out::println);
        return null;
    }

    public ArrayList<Message> getMessagesForId(Id Id) {
        ArrayList<Message> toMess = new ArrayList<>();
       for(Message m : messagesSeen){
            if(m.getToId().equals(Id.toString())){
                toMess.add(m);
            }
        }
        Message m = null;
        //messagesSeen.forEach((m.equals(Id.toString()))::(toMess.add(m)));
        return toMess;
    }

    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId) throws IOException {
          Message msg = new Message("Hello there", myId.getGithub(), "-");
//        msg.setMessage("Hello there");
//        msg.setToId("EthanMaiorini");
//        msg.setFromId("-");
        ServerController.shared().messagePost(msg, myId.getGithub() );
        return msg;
    }
 
}