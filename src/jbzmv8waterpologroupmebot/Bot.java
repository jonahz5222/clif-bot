/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author jonahzukosky
 */
public class Bot implements java.io.Serializable {
    
    private final String ID = "3dece70b7805dd6d37d56dea07";
    private final String name = "Clif";
    private  ArrayList<Message> messageList;
    private MessageSender messageSender;
    
    private Bot() {
        
        messageList = new ArrayList<>();
        messageSender = new MessageSender();
        
    }
    
    
    
    public void sendTextMessage(String message){
            messageSender.sendTextMessage(message, ID);
    }
    public String getID(){
        return ID;
    }
    

    public String getName(){
        return this.name;
    }

    public ArrayList<Message> getMessageList(){
        return this.messageList;
    }
    
    public void setMessageList(ArrayList<Message> messageList){
        this.messageList = messageList;
    }
        
    
    
    public void initFromJsonString(String jsonString) {
        
        messageList = null;




        if (jsonString == null || jsonString == "") return;

        JSONObject jsonObj;
        JSONArray jsonArray;

        try {
            jsonObj = (JSONObject)JSONValue.parse(jsonString);


        } catch (Exception ex) {
            return;
        }

        if (jsonObj == null) {
            return;
        }


        
        //messageList = (ArrayList<Message>)jsonObj.get("messageList");
        jsonArray = (JSONArray) jsonObj.get("messageList");
//        String testString = (String) jsonObj.get("messageList");
//        System.out.println("bot.java : " + testString);
//        System.out.println("bot.java: "+messageList);
        
        
        for(int i = 0; i<jsonArray.size();i++){
            jsonObj = (JSONObject) jsonArray.get(i);
//            Message message = new Message((String)jsonObj.get("title"),
//                                          (String)jsonObj.get("string"),
//                                          (Date)jsonObj.get("date"),
//                                          (Integer)jsonObj.get("time"));
            
            
//            System.out.println("jsonArray: " + message);
//            messageList.add(message);
            
        }

        System.out.println("Message List: " + messageList.size());
        for(int i = 0; i < messageList.size(); i++){
            System.out.println(messageList.get(i));
        }


    }
        
    public static Bot getInstance() {
        return BotSingletonHolder.INSTANCE;
    }
    
    private static class BotSingletonHolder {

        private static final Bot INSTANCE = new Bot();
    }
}
