package com.badbadcode.application.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements IEmailService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean sendEmail(String toEmail, String body)  {
		LOGGER.info("To : {}", toEmail);
		return sendEmailWithAttachment("softcorp.consultacy@gmail.com", toEmail, "Confirmacion | SOFTCORP", body);
	}
	
	private boolean sendEmailTool(String from, String to,String subject, String body) {
		boolean send = false;
		 SimpleMailMessage mail = new SimpleMailMessage();
	        try {
				//mail.setFrom(from);
				mail.setTo(to);
				mail.setSubject(subject);
				mail.setText(body);
				javaMailSender.send(mail);
				send = true;
			} catch (MailException e) {
				send = false;
				e.printStackTrace();
			}
	        return send;
	}
	public boolean sendEmailWithAttachment(String from, String to,String subject, String body) {

		boolean send = false;
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);

			ClassPathResource classPathResource = new ClassPathResource("SOFTCORP.pdf");
			helper.addAttachment(classPathResource.getFilename(), classPathResource);
			javaMailSender.send(mimeMessage);
			send = true;
		} catch (MailException | MessagingException e) {
			send = false;
			e.printStackTrace();
		}
		
		return send;
	}
	

	
	
}