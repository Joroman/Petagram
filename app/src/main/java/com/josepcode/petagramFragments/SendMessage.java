package com.josepcode.petagramFragments;

import android.os.AsyncTask;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Created by JR on 06/06/2016.
 */
public class SendMessage {
    private String mNombreContacto;
    private String mEmail;
    private String mTexto;
    private Session session = null;
    String from;

    public SendMessage(String nombreContacto, String email, String texto) {
        mNombreContacto = nombreContacto;
        mEmail = email;
        mTexto = texto;
    }

    public void enviarMensaje() {
        // Recipient's email ID needs to be mentioned.
        String to = mEmail;

        // Sender's email ID needs to be mentioned
        from = "pepinho@gmail.com";

        // Assuming you are sending email from localhost
        /**       String host = "localhost";

         // Get system properties
         Properties properties = System.getProperties();

         // Setup mail server
         properties.setProperty("smtp.gmail.com", host);
         **/


        ///////
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.port", "465");

        // Get the default Session object.
        // session = Session.getDefaultInstance(props);
        session = Session.getDefaultInstance(props);
        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();

    }


        class RetreiveFeedTask extends AsyncTask {
        protected String doInBackground (String...urls){
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pepinho@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(from));
            message.setSubject(mNombreContacto);
            message.setContent(mTexto, "text/html; charset=utf-8");

            Transport.send(message);


            } catch (MessagingException e) {
              e.printStackTrace();
            } catch (Exception e) {
             e.printStackTrace();
            }
            return null;
        }

            @Override
            protected Object doInBackground(Object[] params) {
                return null;
            }
        }


}


