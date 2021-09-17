/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    
    private static Object sql;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelegramBot(){
    
        conn = this.ConnectDb();
        System.out.println("Successfully connected Bot to Database");
    }
    
    public static Connection ConnectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT" , "root","Am@nzaim123");     // check this again as well
            return conn;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    @Override
    public void onUpdateReceived(Update update) {

            if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            //String message_text = update.getMessage().getText();
            //long chat_id = update.getMessage().getChatId();                     
            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId("622022164")
                    .setText("Your Visitor has arrived!");
            try {
                this.execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public String getBotUsername(){
        return "ResidentNotiBot";
    }
    
    @Override
    public String getBotToken() {
        return "996132107:AAGfFcJLAF3oFfDKfHRnhO3JORS30MjnwnQ";
    }
    
}
