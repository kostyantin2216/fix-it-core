package com.fixit.core.config;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.general.PropertyGroup;
import com.fixit.core.general.PropertyGroup.Group;
import com.fixit.core.general.StoredProperties;
import com.fixit.core.logging.FILog;

@Configuration
@ComponentScan(basePackages = {"com.fixit.core"})
public class CoreConfiguration {
	
	@Bean
	@Autowired
	public Session mailSession(StoredPropertyDao dao) {
		FILog.i("creating mail session");
		PropertyGroup propertyGroup = dao.getPropertyGroup(Group.mail);
		
		final String username = propertyGroup.getString(StoredProperties.MAIL_USERNAME, null);
		final String password = propertyGroup.getString(StoredProperties.MAIL_PASSWORD, null);

		Properties props = propertyGroup.extractProperties(
				StoredProperties.MAIL_SMTP_AUTH,
				StoredProperties.MAIL_SMTP_ENABLE_TLS,
				StoredProperties.MAIL_SMTP_HOST,
				StoredProperties.MAIL_SMTP_PORT
		);
		
		return Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}
	
}
