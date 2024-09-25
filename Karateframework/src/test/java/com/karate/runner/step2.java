package com.karate.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class step2 {
	
	
	/*
	 * public static void main(String[] args) throws Exception, Exception{
	 * 
	 * generateKarateToken(); }
	 * 
	 */
	
	public static String loginMessage() {
		
		return "API Automation testing training demo example";
	}
	
	public static String generateKarateToken() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		String tokenValue = null;
 HttpClient httpclient = HttpClients.createDefault();
try {
 HttpPost httppost = new HttpPost("https://ap16.salesforce.com/services/oauth2/token");

// Request parameters and other properties.
 List<NameValuePair> params = new ArrayList<NameValuePair>();
 params.add(new BasicNameValuePair("grant_type", "password "));
 params.add(new BasicNameValuePair("client_id",
 "3MVG9n_HvETGhr3DQnMnGOSDtjzrG2mAOYVdSV5evS.tTlNfq2L226pwgLnbCb5zAWgqLyId4ZLU9.Eh.13fH"));
 params.add(new BasicNameValuePair("client_secret",
 "587ADD7D0BE0458B2889585821C3E40B457710775B03D9A0A50A8B927039C2CD"));
 params.add(new BasicNameValuePair("username", "kamurthy@deloitte.com"));
 params.add(new BasicNameValuePair("password", "NewPass@123NpKFpUND3n8HoS1KR6OFuUMs4"));
 httppost.setEntity(new UrlEncodedFormEntity(params));
 org.apache.http.HttpResponse response = httpclient.execute(httppost);

 if(response!=null) {
 String json=EntityUtils.toString(response.getEntity());
 Map<String, String> map = mapper.readValue(json, Map.class);
 tokenValue=map.get("access_token");
 
 }
} catch (Exception e) {
 e.printStackTrace();
}
System.out.println(tokenValue);
		return tokenValue;


	}
	


}