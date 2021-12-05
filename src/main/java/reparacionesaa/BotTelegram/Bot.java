package reparacionesaa.BotTelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

   @Override
   public void onUpdateReceived(Update update) {
      
      if (update.hasMessage() && update.getMessage().hasText()) {
         SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
         message.setChatId(update.getMessage().getChatId().toString());
         message.setText(update.getMessage().getText());
         
         try {
             execute(message); // Call method to send the message
         } catch (TelegramApiException e) {
             e.printStackTrace();
         }
         System.out.println(update.getMessage().getText());
         System.out.println(update.getMessage().getFrom().getFirstName());
      }
   }

   @Override
   public String getBotUsername() {
      
      return "pruebapoo_bot";
   }

   @Override
   public String getBotToken() {
      
      return "2071537624:AAHCmgUGwtnSJc2os5w6WAcSjcpb15Z_WL0";
   }
   
}
