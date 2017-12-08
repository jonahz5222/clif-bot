/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author jonahzukosky
 */
public class Jbzmv8WaterPoloGroupMeBot extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        
        Scene scene = new Scene(root);
        
        
        Switchable.scene = scene;
        Switchable.switchTo("LoginView");
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(final WindowEvent event) {
            
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
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    @Override 
    public void stop() throws Exception{
        super.stop();
        
        if(!MainModel.timer.equals(null)){
            MainModel.timer.cancel();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
