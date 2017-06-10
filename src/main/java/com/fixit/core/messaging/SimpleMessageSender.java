/**
 * 
 */
package com.fixit.core.messaging;

import org.springframework.stereotype.Component;

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

	public String sendMessage(String number, String content) {
		return Message.creator(new PhoneNumber(number), fromNumber, content).create().getSid();
	}

	public static final String ACCOUNT_SID = "AC232dcff4d93962f9c1cc37a98d5473a2";
	public static final String AUTH_TOKEN = "79b52bae36be72678c0a18a9ae022ac7";

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		System.out.println("creating message...");

		Message sms = Message.creator(new PhoneNumber("+972502835431"), new PhoneNumber("+18325643384"),
		        "All in the game, yo").create();

		System.out.println(sms.getSid());
	}

}
