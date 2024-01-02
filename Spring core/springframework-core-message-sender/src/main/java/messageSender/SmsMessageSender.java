package messageSender;

public class SmsMessageSender implements MessageSender{

     @Override
     public void sendMessage(User user, String message){
          System.out.println("SMS sender Message  " + user.getEmail() + " : " + message);
     }
}
