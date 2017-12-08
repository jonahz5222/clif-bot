/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author jonahzukosky
 */
public class MessageViewController extends Switchable implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Bot bot = Bot.getInstance();
    @FXML
    ChoiceBox timePicker;
    
    @FXML
    TextArea messageField;
    
    @FXML
    TextField titleField;
    
    @FXML
    ChoiceBox freqPicker;
    
    @FXML
    DatePicker startDatePicker;
    
    @FXML
    DatePicker endDatePicker;
    
    @FXML
    Text errorText;
    @FXML
    
    public void handleSubmit(ActionEvent event){
        


        
        
        
        Date tempDate;
        Date endDate;
        int time = (int)timePicker.getValue();
        int frequency = (int)freqPicker.getValue();
        String string = messageField.getText();
        String title = titleField.getText();
        
        LocalDate localDate = startDatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        tempDate = Date.from(instant);
        
        localDate = endDatePicker.getValue();
        instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        endDate = Date.from(instant);
        
        
        
        String errorMessage;
        
        
        errorMessage = MessageModel.messageListMaker(tempDate, endDate, time, frequency, string, title);
        
        
        
        if(errorMessage.equals("")){
            messageField.setText("");
            titleField.setText("");
            startDatePicker.getEditor().clear();
            endDatePicker.getEditor().clear();
            
            
            



            Switchable.switchTo("MainView");
        }else{
            errorText.setText(errorMessage);
        }
                
        
    }
    
    @FXML
    public void handleCancel(ActionEvent event){
        messageField.setText("");
        titleField.setText("");
        startDatePicker.getEditor().clear();
        endDatePicker.getEditor().clear();
        errorText.setText("");
        Switchable.switchTo("MainView");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        timePicker.setItems(FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23));
        
        
        
        
        
        
        freqPicker.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7));
    }    
    
}
