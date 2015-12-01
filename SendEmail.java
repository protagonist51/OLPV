package org.itc.utility;

/*import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/



import org.apache.velocity.app.VelocityEngine;

import org.itc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("crunchifyEmail")
public class SendEmail
{
	

	/*-------------- first way---------------------------*/

	/*public User emailSender(User user)
	{
	System.out.println("Inside SendEmail class");
	
    String to = user.getEmail();
    String from = "noreply@scrumtracker.com";
    String host = "10.6.12.229";
    String port = "389";
    String protocol = "smtps";
    String debug	=  "true";
    
    
    Properties properties = new Properties();
    properties.setProperty("mail.smtps.host", host);
   
    properties.setProperty("mail.smtps.port", port);
    properties.setProperty("mail.transport.protocol", protocol);
    properties.setProperty("mail.debug", debug);
    
   
    Session session = Session.getInstance(properties);
    
    
    
    try{
        MimeMessage message = new MimeMessage(session);
        
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Your password has been changed");
        message.setText("Your new password is"+ user.getPassword());     
        System.out.println("autogenrate passwd in sendEmail"+ user.getPassword());
        
        Transport.send(message);
        System.out.println("message sent sucessfully");


    	
    }
    catch(Exception expmsg)
    	{
    	expmsg.printStackTrace();
		return null;
		
	}
    
    return user;

	}*/
	
	/*--------------End------------------------------------------*/
	
	/*----------------second way-----------------------------------*/
	
	
	/*@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	private SimpleMailMessage templateMessage;

	public void emailSender(final User user) throws Exception 
	{
		System.out.println("Inside SendEmail class");
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
		
		message.setFrom(templateMessage.getFrom());
		message.setTo(user.getEmail());
		
		System.out.println("from "+templateMessage.getFrom());
		System.out.println("to " + user.getEmail());
		
		message.setSubject(templateMessage.getSubject());
		message.setText("your new password is " +user.getPassword());
		System.out.println("new password is "+user.getPassword());
		System.out.println("subject "+templateMessage.getSubject());
	
		
		Map<String, User> model = new HashMap<String, User>();
		model.put("user", user);
		
		if (mailSender != null)
		{
			System.out.println(mailSender);
			mailSender.send(mimeMessage);
			System.out.println(mimeMessage);
		}
		
		
	}
	

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public SimpleMailMessage getTemplateMessage() {
		return templateMessage;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}*/

	/*---------------End-------------------------------------------*/
	
	
	/*-----------------third way--------------------------------------*/
	
	/*@Autowired
	 private JavaMailSender  mailSender;
	@Autowired
	 private VelocityEngine velocityEngine;
	@Autowired
	 private SimpleMailMessage templateMessage;
	 

	public void emailSender(final User user) throws Exception 
	{
		
	   		
		SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
	
		message.setFrom(templateMessage.getFrom());
		message.setTo(user.getEmail());
		System.out.println(user.getEmail());
		
		message.setSubject(templateMessage.getSubject());
		System.out.println(templateMessage.getSubject());
		
		
		message.setText("Your new password is "+ user.getPassword());
		System.out.println("Your new password is "+ user.getPassword());
		
		mailSender.send(message);
		System.out.println(message);
		
	}
	
	
	

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public SimpleMailMessage getTemplateMessage() {
		return templateMessage;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	*/
	
	@Autowired
	private MailSender crunchifymail;

	public MailSender getCrunchifymail() {
		return crunchifymail;
	}

	public void setCrunchifymail(MailSender crunchifymail) {
		this.crunchifymail = crunchifymail;
	}
	
	
	public void emailSender(final User user) throws Exception 
	{
	
		String from = "noreply@itc.com";
		String to	=	user.getEmail();
		String subject = "changed password";
		String msgBody = "your password has been changed. your new password is "+ user.getPassword();
		
		
		System.out.println("inside send email class " + user.getPassword());
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(from);
		crunchifyMsg.setTo(to);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(msgBody);
		crunchifymail.send(crunchifyMsg);
		System.out.println("mail  successfully sent");
	}

}
