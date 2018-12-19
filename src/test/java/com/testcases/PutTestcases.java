package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basetest.TestBase;
import com.client.RestClient;
import com.data.Postdata;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PutTestcases extends TestBase {
	
	Random random= new Random();
	TestBase testBase;
	String posts;
	String users;
	String comments;
	CloseableHttpResponse closeableHttpResponse;

	RestClient restclient;
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		posts = config.getProperty("posts");
		comments = config.getProperty("comments");
		users = config.getProperty("users");

	}
	
	@Test (priority=1)
	public void updateposts() throws JsonGenerationException, JsonMappingException, IOException {
		restclient= new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type","application/json" );
		
		ObjectMapper objectmapper= new ObjectMapper();
		Postdata postrequest= new Postdata(476634570,1171578713,"updatedpostsreqapitest","api@apitest.com","API test automation");
		System.out.println(postrequest);
		objectmapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\data\\postdata.json"),postrequest);
		String postrequestdata=objectmapper.writeValueAsString(postrequest);
		System.out.println(postrequestdata);
		closeableHttpResponse  =restclient.putrequest(posts, postrequestdata, headermap);
	}
	
	@Test(priority=2)
	public void updatecomment() throws JsonGenerationException, JsonMappingException, IOException {
		restclient= new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type","application/json" );
		
		ObjectMapper objectmapper= new ObjectMapper();
		Postdata commentsdata= new Postdata(1134198233,1151325848,"updatedcommentsapitest","api@apitest.com","API test automation");
		System.out.println(commentsdata);
		objectmapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\data\\commentsdata.json"),commentsdata);
		String postrequestdata=objectmapper.writeValueAsString(commentsdata);
		System.out.println(commentsdata);
		closeableHttpResponse  =restclient.putrequest(comments, postrequestdata, headermap);
	}
	
	@Test(priority=3)
	public void updateusers() throws JsonGenerationException, JsonMappingException, IOException {
		restclient= new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type","application/json" );
		
		ObjectMapper objectmapper= new ObjectMapper();
		Postdata usersdata= new Postdata(4894,5841,"updatedusersapitest","api@apitest.com","API test automation");
		System.out.println(usersdata);
		objectmapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\data\\usersdata.json"),usersdata);
		String postrequestdata=objectmapper.writeValueAsString(usersdata);
		System.out.println(usersdata);
		closeableHttpResponse =restclient.putrequest(users, postrequestdata, headermap);
	
	}
	
	
}






