/**
 * 
 */
package com.fixit.core.messaging;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/15 23:12:53 GMT+3
 */
public class SimpleMessageSender {

	private final PhoneNumber fromNumber;

	public SimpleMessageSender(String fromNumber) {
		this.fromNumber = new PhoneNumber(fromNumber);
	}

	public void sendMessage(String number, String content) {
		
	}

	public static final String ACCOUNT_SID = "AC5a4333803bea0ed40ae07b99e3448628";
	public static final String AUTH_TOKEN = "5079f98450f890296028406d12f3c27d";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		System.out.println("creating message...");

		Message sms = Message.creator(new PhoneNumber("+972502835431"), new PhoneNumber("15005550006"),
		        "All in the game, yo").create();

		System.out.println(sms.getSid());
	}

}
