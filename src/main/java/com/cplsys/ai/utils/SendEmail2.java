package com.cplsys.ai.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import java.security.Security;
import java.util.Date;


import com.sun.mail.smtp.SMTPTransport;

public class SendEmail2 {
	String to = "carlos.palalia@aisa-automation.com";
	String host = "localhost";
	
	MimeMessage message;
	Properties properties;
	Session session;    

    public SendEmail2(String from, String subject, String messageIn){
    	try {
    		properties = System.getProperties();
    		properties.setProperty("mail.smtp.host", host);
    		session = Session.getDefaultInstance(properties);
    		message = new MimeMessage(session);

    		message.setFrom(new InternetAddress(from));
    		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    		message.setSubject(subject);
    		message.setText(messageIn);
    		
    		//Send message
    		Transport.send(message);
    		System.out.println("Sent message successfully....");
	    }catch (MessagingException mex) {
	       mex.printStackTrace();
	    }
    }
}
