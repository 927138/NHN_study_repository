package messageSender;

public class EmailMessageSender implements MessageSender{
     @Override
     public void sendMessage(User user, String message) {
          System.out.println("Email send message  "+ user.getEmail() + " : " + message);
     }
}
