package com.dqm.mvpframe.model.bean;

public class User {

	public String userName;
	public String userPwd;
	public String token;
	private User user;
	
	private int id;
	
	public int getId() {
		return id;
	}
	public User(String user, String usePwd) {
		userName = user;
		userPwd = usePwd;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
