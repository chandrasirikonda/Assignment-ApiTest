package com.data;

public class Postdata {

	int userId;

	int id;

	String title;

	String body;

	String email;

	String postId;
	
	String username;
	
	String name;
	
	public Postdata(int userId,int id,String name,String email,String body) {
		
		
		this.id = id;
		this.body = body;
		this.email = email;
		this.userId = userId;
		this.name=name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}