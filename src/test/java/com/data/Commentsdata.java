package com.data;

public class Commentsdata {
	int postId;
	int id;
	String name;
	String body;
	String email;

	public Commentsdata(int postId,int id,String name,String email,String body) {
		
		
		this.id = id;
		this.body = body;
		this.email = email;
		this.postId = postId;
		this.name=name;
	}
	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
