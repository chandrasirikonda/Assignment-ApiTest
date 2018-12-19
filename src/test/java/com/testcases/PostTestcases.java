package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basetest.TestBase;
import com.client.RestClient;
import com.data.Postdata;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostTestcases extends TestBase {
	Random random = new Random();
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

	@Test(priority = 1)
	public void postrequest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");

		ObjectMapper objectmapper = new ObjectMapper();
		Postdata commentsdata = new Postdata(random.nextInt(10000), random.nextInt(10000), "commentsapitest",
				"api@apitest.com", "API test automation");
		System.out.println(commentsdata);
		objectmapper.writeValue(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\data\\postdata.json"),
				commentsdata);
		String postrequestdata = objectmapper.writeValueAsString(commentsdata);
		closeableHttpResponse = restclient.postrequest(posts, postrequestdata, headermap);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		System.out.println(responseString);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);
	}

	@Test(priority = 2)
	public void commentsrequest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");

		ObjectMapper objectmapper = new ObjectMapper();
		Postdata commentsdata = new Postdata(random.nextInt(10000), random.nextInt(10000), "commentsapitest",
				"api@apitest.com", "API test automation");
		System.out.println(commentsdata);
		objectmapper.writeValue(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\data\\commentsdata.json"),
				commentsdata);
		String postrequestdata = objectmapper.writeValueAsString(commentsdata);
		closeableHttpResponse = restclient.postrequest(comments, postrequestdata, headermap);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		System.out.println(responseString);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);
	}

	@Test(priority = 3)
	public void usersrequest() throws JsonGenerationException, JsonMappingException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");

		ObjectMapper objectmapper = new ObjectMapper();
		Postdata usersdata = new Postdata(random.nextInt(10000), random.nextInt(10000), "usersapitest",
				"api@apitest.com", "API test automation");
		objectmapper.writeValue(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\data\\usersdata.json"), usersdata);
		String postrequestdata = objectmapper.writeValueAsString(usersdata);
		closeableHttpResponse = restclient.postrequest(users, postrequestdata, headermap);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		System.out.println(responseString);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);

	}

}
