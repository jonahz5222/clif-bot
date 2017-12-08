/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jonahzukosky
 */


public class LoginViewController extends Switchable implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    
    @FXML
    public TextField usernameField = new TextField();
    
    @FXML
    public PasswordField passwordField = new PasswordField();
    
    @FXML
    public Button loginButton = new Button();
    
    @FXML
    public Text errorMessage = new Text();
    @FXML
    public MenuBar menuBar;
    @FXML
    
    private void handleLoginButton(ActionEvent event){
                
        errorMessage.setText("");
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean loginCheck;
        
        //System.out.println(username);
        //System.out.println(password);
        //Switchable.switchTo("MainView");
        
        if(!username.equals("")){
            
            loginCheck = LoginModel.loginCheck(username,password);
            
            if(loginCheck){
                //Change Scenes
                
                
                
                
                
                    

                    usernameField.setText("");
                    passwordField.setText("");
                    Switchable.switchTo("MainView");
        
                
            }
            else{
                errorMessage.setText("Incorrect Username or Password");
                passwordField.setText("");
            }
        }
        else{
            errorMessage.setText("You must enter a Username");
            passwordField.setText("");
        }
    }
    
    
    @FXML
    private void handleAboutButton(ActionEvent event){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Clif the Water Polo Bot");
        alert.setContentText("This application was developed for use by the University of Missouri Water Polo Club by Jonah Zukosky for CMP_SC 3330's "
                + "final project. It's purpose is to make weekly reminders easier for the team and to more efficiently gain information about practices");
      
        
        alert.showAndWait();
    }
    
    
        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        usernameField.setPromptText("username");
        passwordField.setPromptText("password");

        
    }    
    
}
