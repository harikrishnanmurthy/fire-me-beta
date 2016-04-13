package com.fireme.utilities;

import java.util.ArrayList;
import java.util.List;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SendSMS {

	public static void sendSMS(String recipientNumber,String smsContent) {
		// TODO Auto-generated method stub
		    try {
		        TwilioRestClient client = new TwilioRestClient("ACaa3e14e25c6be7f3681a9cccbd89864b", "e601e86937fd3882bbe7f574c1075e8f");
		 
		        // Build a filter for the MessageList
		        List<NameValuePair> params = new ArrayList<NameValuePair>();
		        params.add(new BasicNameValuePair("Body", smsContent));
		        params.add(new BasicNameValuePair("To", recipientNumber)); //Add real number here
		        params.add(new BasicNameValuePair("From", "+12016901866"));

		        MessageFactory messageFactory = client.getAccount().getMessageFactory();
		        Message message = messageFactory.create(params);
		        System.out.println(message.getSid());
		    } 
		    catch (TwilioRestException e) {
		        System.out.println(e.getErrorMessage());
		    }
		}


}
