/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

/**
 *
 * @author jonahzukosky
 * 
 */
public abstract class LoginModel {
    
    
    private static String TruePassword = "password";
    private static String TrueUsername = "username";
    
    
    public static boolean loginCheck(String username, String password){
        //For now this is Plain Text, in the future it will not be
        
        if(username.equals(TrueUsername)){
            
            if(password.equals(TruePassword)){
                
                return true;
            }
        }
    return false;
    }
    
}
