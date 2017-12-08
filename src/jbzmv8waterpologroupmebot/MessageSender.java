package jbzmv8waterpologroupmebot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
* Created with help from William Reed's Groupme Bot Wrapper
*
* Github link: https://github.com/william-reed/GroupMe-Bots-Java-Wrapper
*/

public class MessageSender implements java.io.Serializable
{
	private final String REQUEST_URL = "https://api.groupme.com/v3/bots/post";

	public void sendTextMessage(String message, String botID)
	{
		String urlParameters = "bot_id=" + botID + "&text=" + message + "&param3=c";
		try
		{
			URL url = new URL(REQUEST_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			connection.disconnect();

			int responseCode = connection.getResponseCode();
			if (responseCode != 202)
				System.out.println(responseCode + " error has occured while sending the message: " + message);
		} catch (MalformedURLException e)
		{
			System.out.println("Error occured while establishing a connection");
			e.printStackTrace();
		} catch (IOException e)
		{
			System.out.println("Error occured while sending data");
			e.printStackTrace();
		}
	}

	

	
	
}
