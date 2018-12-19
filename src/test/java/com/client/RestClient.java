package com.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	// getmethod
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); // http get request
		for (Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse = httpClient.execute(httpget); // hit the GET URL
		return closebaleHttpResponse;

	}

	// postmethod
	public CloseableHttpResponse postrequest(String url, String entityString, HashMap<String, String> headermap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(new StringEntity(entityString));
		for (Map.Entry<String, String> entry : headermap.entrySet()) {
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse postresponse = httpclient.execute(httppost);
		return postresponse;
	}

	// put method
	public CloseableHttpResponse putrequest(String url, String entityString, HashMap<String, String> headermap)
			throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPut httpput = new HttpPut(url);
		httpput.setEntity(new StringEntity(entityString));
		for (Map.Entry<String, String> entry : headermap.entrySet()) {
			httpput.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse putresponse = httpclient.execute(httpput);
		return putresponse;
	}

}
