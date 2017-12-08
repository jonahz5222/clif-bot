/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 *
 * @author jonahzukosky
 */
public class Message implements Comparable<Message>,java.io.Serializable{
    
    private String title;
    private String string;
    private Date date;
    private int time;
    
    
    
    public Message(){
        
    }
            
    public Message(String title,String string,Date date,Integer time){
        this.title = title;
        this.string = string;
        this.date = date;
        this.time = time;
    }
    
    public void setTitle(String title){
        
        this.title = title;
        
    }
    
    public String getTitle(){
        return this.title;
    }
    public void setString(String message){
        this.string = message;
    }
    
    public String getString(){
        return this.string;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @param date the startDate to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

   

    /**
     * @return the time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time; 
    }

    @Override
    public int compareTo(Message o) {
        return getDate().compareTo(o.getDate());
    }

   
}
