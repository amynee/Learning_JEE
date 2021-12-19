package com.octest.forms;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	private String result;
	
	public void verifyUser(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if (password.equals(login + "123")) {
			result = "You are connected";
		} else {
			result = "Something went wrong";
		}
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
}
