package com.fixit.core.config;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.general.PropertyGroup;
import com.fixit.core.general.PropertyGroup.Group;
import com.fixit.core.general.StoredProperties;
import com.fixit.core.logging.FILog;
import com.fixit.core.messaging.SimpleEmailSender;
import com.fixit.core.messaging.SimpleMessageSender;
import com.twilio.Twilio;

@Configuration
@ComponentScan(basePackages = {"com.fixit.core"})
@PropertySource("classpath:mongo.properties")
public class CoreConfiguration {
	
	@Bean
	@Autowired
	public MongoClientManager mongoClientManager(Environment env) {
		FILog.i("creating mongo client manager");
		return new MongoClientManager(env);
	}
	
	@Bean
	@Autowired
	public SimpleMessageSender simpleMessageSender(StoredPropertyDao dao) {
		FILog.i("creating simple message sender");
		PropertyGroup propertyGroup = dao.getPropertyGroup(Group.sms);
		
		String accSid = propertyGroup.getString(StoredProperties.SMS_TWILIO_ACC_SID, null);
		String authToken = propertyGroup.getString(StoredProperties.SMS_TWILIO_AUTH_TOKEN, null);
		
		Twilio.init(accSid, authToken);
		
		return new SimpleMessageSender(propertyGroup.getString(StoredProperties.SMS_ORDER_FROM_TELEPHONE, null));
	}
	
	@Bean
	@Autowired
	public SimpleEmailSender simpleEmailSender(StoredPropertyDao storedPropertyDao) {
		FILog.i("creating simple email sender");
		PropertyGroup propertyGroup = storedPropertyDao.getPropertyGroup(Group.mail);
		
		final String username = propertyGroup.getString(StoredProperties.MAIL_USERNAME, null);
		final String password = propertyGroup.getString(StoredProperties.MAIL_PASSWORD, null);

		Properties props = propertyGroup.extractProperties(
				StoredProperties.MAIL_SMTP_AUTH,
				StoredProperties.MAIL_SMTP_ENABLE_TLS,
				StoredProperties.MAIL_SMTP_HOST,
				StoredProperties.MAIL_SMTP_PORT
		);
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		PropertyGroup pg = storedPropertyDao.getPropertyGroup(Group.mail);
		String from = pg.getString(StoredProperties.MAIL_USERNAME, "");
		try {
			return new SimpleEmailSender(session, from);
		} catch (AddressException e) {
			// this should not happen unless an illegal email is entered in stored properties.
			throw new IllegalArgumentException("Could not create mail sender with from email: " + from);
		}
	}
	
}
