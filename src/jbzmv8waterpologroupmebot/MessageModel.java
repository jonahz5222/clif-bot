/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jonahzukosky
 */
public abstract class MessageModel {
    
    
    public static String messageListMaker(Date tempDate,Date endDate, int time,int frequency,String string,String title){
        
        
        Bot bot = Bot.getInstance();
        ArrayList<Message> messageList = bot.getMessageList();
        
        if(!string.equals("") && !title.equals("") && !tempDate.equals(null) && !endDate.equals(null)){
            if(tempDate.before(endDate) || tempDate.equals(endDate)){
                System.out.println("Start Date: " + tempDate);
                System.out.println("End Date: " + endDate);
                System.out.println("Time: " + time);
                System.out.println("Frequency: " + frequency);
                
                //System.out.println("tempDate in messageModel: " + tempDate);
                
                while(tempDate.before(endDate)){
                    
                    
                    
                    while(tempDate.before(endDate)){
                        
                        Message message = new Message(title,string,tempDate,time);
                        messageList.add(message);
                        
                        Calendar c = Calendar.getInstance();
                        c.setTime(tempDate);
                        c.add(Calendar.DATE, frequency);  // number of days to add
                       
                        tempDate = c.getTime(); 
                        
                        System.out.println("tempDate in messageModel: " + tempDate);
                    }


                }
                
                
                bot.setMessageList(messageList);
                System.out.println("message model: " + bot.getMessageList());
                return "";
            }
            
            return "You must pick a start date before or equal to the end date";
        }
        
        return "You must enter a value for all forms";
    }
}
