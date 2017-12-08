/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbzmv8waterpologroupmebot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author jonahzukosky
 */
public class MainModel {
    
    
    static Timer timer;
    
    
    public static void timer() {
    timer = new Timer();
        
        Bot bot = Bot.getInstance();
        ArrayList<Message> messageList = bot.getMessageList();
        
        
        for(Message message: messageList){
            
            
            TimerTask sendCheck = new TimerTask(){


            @Override
            public void run(){
                
                    Date nowDate = new Date();
                    System.out.println(message.getDate());
                    if(message.getDate().before(nowDate) || message.getDate().equals(nowDate)){
                        System.out.println("run: " + nowDate);

                        Calendar cal = Calendar.getInstance(); 

                        int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23

                        if(hour >= message.getTime()){
                            bot.sendTextMessage(message.getString());
                            messageList.remove(message);
                            this.cancel();
                        }  
                        


                    }
                }
            
            };
            timer.schedule(sendCheck, 1000,1000*5);
        }
    
    
    }
    
}
