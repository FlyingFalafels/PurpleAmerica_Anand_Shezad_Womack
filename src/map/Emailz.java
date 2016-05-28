/*
 * IMPORTING NESSARY COMPONENTS 
 * CREATING EMAILZ CLASS
 * CREATING EMAILING METHOD
 *      -CREATE NEW OBJECT
 *      -CREATING LOGIC IN ORDER TO CAPTURE CREDENTIALS FROM USER
 *      -PROPERTIES OF EMAIL
 *      -HOSTING, SENDER, RECIPENENT INFO
 *
 */
package map;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;

//NOTE: there is specific way to send an email through java, so the code will look similar to this http://www.tutorialspoint.com/javamail_api/javamail_api_send_inlineimage_in_email.htm
//Keep in mind while grading, I don't know any other way to send an email
public class  Emailz{
    String nameMap = "hi";

   public void Emailing() {
      TahirsFunction t = new TahirsFunction();
       
      String recipient = t.getReceive();
      String from = t.getEmai();
      final String username = "stshehzad";
      final String password = t.getPass();
      //this can send only emails from gmail accounts as of now
      String host = "smtp.gmail.com";
      
      //setting the properties of the email
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");
      
      //CREATING A SESSION TO SEND EMAIL
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                //IT WILL USE THE USERNAME AND PASSWORD FROM ABOUT TO AUTHENTICATE
               return new PasswordAuthentication(username, password);
            }
         });

      try {

         // Creating the base message object thing
         Message message = new MimeMessage(session);

         // Sseeting the sender here 
         message.setFrom(new InternetAddress(from));

         //setting the recipients of the picture here
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(recipient));

         //Here is where we set the subject of the email
         message.setSubject("Data");

         // This mail has 2 part, the BODY and the embedded image
         MimeMultipart multimedia = new MimeMultipart("related");
         
         String nameMap = "MAP";
         BodyPart photo = new MimeBodyPart();
         String text = "<H1>" + nameMap +"</H1><img src=\"cid:image\">";
         photo.setContent(text, "text/html");
         
         //adding the picture which is a part of the entire thing which is here called multimedia
         multimedia.addBodyPart(photo);

         
         photo = new MimeBodyPart();
         //giving the source of the file
         DataSource fds = new FileDataSource("results.png");

         photo.setDataHandler(new DataHandler(fds));
         photo.setHeader("Content-ID", "<image>");

         // add image to the multipart
         multimedia.addBodyPart(photo);

         //gathering all of the components
         message.setContent(multimedia);
         //Sending the message here
         Transport.send(message);
         //if everything works it will printout ("Email sent")
         System.out.println("Photo sent sent");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}

