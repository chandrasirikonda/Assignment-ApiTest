package com.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.basetest.TestBase;
import com.client.RestClient;

public class GetTestcases extends TestBase {
	TestBase testBase;
	String posts;
	String users;
	String comments;
	CloseableHttpResponse closeableHttpResponse;
	RestClient restclient;
	HashMap<String, String> headerMap = new HashMap<String, String>();

	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		posts = config.getProperty("posts");
		comments = config.getProperty("comments");
		users = config.getProperty("users");

	}

	@Test(priority=1)

	public void getpostdata() throws ClientProtocolException, IOException {
		RestClient restclient = new RestClient();
		closeableHttpResponse=restclient.get(posts,headerMap);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		System.out.println(responseString);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200);

	}

	@Test(priority=2)
	public void getcommentsdata() throws ClientProtocolException, IOException {
		RestClient restclient = new RestClient();
		closeableHttpResponse=restclient.get(comments,headerMap);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		System.out.println(responseString);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200);
		
	}

	@Test(priority=3)

	public void getusersdata() throws ClientProtocolException, IOException {
		RestClient restclient = new RestClient();
		closeableHttpResponse=restclient.get(users,headerMap);
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
		System.out.println(responseString);
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200);

	}

}
