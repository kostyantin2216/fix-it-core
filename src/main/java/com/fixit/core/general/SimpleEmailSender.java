package com.fixit.core.general;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fixit.core.logging.FILog;

public class SimpleEmailSender {	
	
	private final Session mSession;
	private final Address mFrom;
	
	public SimpleEmailSender(Session session, String from) throws AddressException {
		mSession = session;
		mFrom = new InternetAddress(from);
	}
	
	public SimpleEmailSender(String host, String from) throws AddressException {
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.host", host);
		mSession = Session.getDefaultInstance(properties);
		mFrom = new InternetAddress(from);
	}
	
	public boolean sendMail(String subject, String content, String to) {
		return sendMail(subject, content, Arrays.asList(new String[] {to}));
	}
	
	public boolean sendMail(String subject, String content, List<String> toList) {
		return sendMail(subject, content, toList, null);
	}

	/**
	 * @param subject
	 * @param content
	 * @param toList List of recipient email's that this email is directed to(recipient is directly involved with the email) cannot be null!
	 * @param ccList List of recipient email's that this email should inform(recipient isn't directly involved but needs to be informed) can be null.
	 * @return
	 */
	public boolean sendMail(String subject, String content, List<String> toList, List<String> ccList) {
		try {
			MimeMessage message = new MimeMessage(mSession);
			message.setFrom(mFrom);
			message.setRecipients(Message.RecipientType.TO, convertToAdresses(toList));
			if(ccList != null && !ccList.isEmpty()) {
				message.setRecipients(Message.RecipientType.CC, convertToAdresses(toList));
			}
			message.setSubject(subject);
			message.setText(content, "utf-8");
			
			Transport.send(message);
			return true;
		} catch(MessagingException e) {
			FILog.e("Could not send emails to " + Arrays.asList(toList) + " with subject: " + subject + ", content: " + content, e);
			return false;
		}
	}
	
	private Address[] convertToAdresses(List<String> emails) throws AddressException {
		Address[] addresses = new Address[emails.size()];
		for(int i = 0; i < emails.size(); i++) {
			addresses[i] = new InternetAddress(emails.get(i));
		}
		return addresses;
	}
}
