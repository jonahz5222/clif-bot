/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author jonahzukosky
 */
public class MainViewController extends Switchable implements SerializationInterface,Initializable {
 
    /**
     * Initializes the controller class.
     */

    private final MainModel mainModel = new MainModel();

    
    @FXML
    private ListView list;
    
    @FXML
    private ListView list1;
    
    
    
    
    
    
    @FXML
    private void handleAboutButton(ActionEvent event){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Clif the Water Polo Bot");
        alert.setContentText("This application was developed for use by the University of Missouri Water Polo Club by Jonah Zukosky. I am the president of Mizzou's Water Polo Club, so I created this application to help myself and my team.It is for CMP_SC 3330's "
                + "final project. It's purpose is to make weekly reminders easier for the team and to more efficiently gain information about practices");
      
        
        alert.showAndWait();
    }
    
    
    @FXML
    @Override
    public void handleLogoutButton(ActionEvent event){
        Switchable.switchTo("LoginView");
        
        
    }
    @FXML
    @Override
    public void handleSaveBot(ActionEvent event){
        
        
        File file = new File("bot.txt");
        Bot bot = Bot.getInstance();
	
        ArrayList<Message> messageList = bot.getMessageList();
        
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(file, messageList);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
}
    
    
    //Solely for test purposes
    @FXML
    private void handleMessageButton(ActionEvent event) {
        
        Switchable.switchTo("MessageView");
        
    }
    
    
 
    
    
    
    
    
    
    
    public void  updateMessageList(){

        
        Bot bot = Bot.getInstance();
        ArrayList<Message> messageList = bot.getMessageList();
        ArrayList<String> concatenatedList = new ArrayList<>();
        
        ArrayList<Message> sortedMessageList = messageList;
        Collections.sort(sortedMessageList);
        
        
        for(Message message : sortedMessageList){
            String tempString = new String("");
            tempString += message.getTitle();
            tempString += "             ";
            tempString += message.getDate().toString();
            tempString += "             ";
            tempString += message.getTime();
            tempString += " Military Time";
            
            
            System.out.println("tempString" + tempString);
            concatenatedList.add(tempString);
        }
        System.out.println("test");
        
        
       list.setItems(FXCollections.observableArrayList(sortedMessageList));
       list1.setItems(FXCollections.observableArrayList(concatenatedList));
        
        
        
    
    

        
        
        
    }
    
    @Override
    public void deserializer(){
        FileReader fileReader = null;
        try {
            Bot bot = Bot.getInstance();
            fileReader = new FileReader("bot.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String json = "";
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                json += line;
            } 
            bufferedReader.close();
            fileReader.close();
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Message> messageList = mapper.readValue(json, new TypeReference<ArrayList<Message>>(){});
            bot.setMessageList(messageList);
            System.out.println("Initialize: " + messageList);
            updateMessageList();
            
            
            
           } catch (FileNotFoundException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void startTimer(){
        MainModel.timer();
    }
    
    
    @FXML
    public void deleteSelectedMessage(){
        Message message = (Message)list.getSelectionModel().getSelectedItem();
        int index = list.getItems().indexOf(message);
        Bot bot = Bot.getInstance();
        
        ArrayList<Message> messageList = bot.getMessageList();
        messageList.remove(message);
        
        
        list1.getItems().remove(index);
        
        updateMessageList();
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        deserializer();
        
            
        
        
        
            
            
            

        
        
    } 
       
    
}
