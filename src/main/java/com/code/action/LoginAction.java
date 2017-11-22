package com.code.action;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2400755020140910724L;
	private String userName;
	private Integer userID;
	private String message;

	private static final Set<Integer> ALLOWED_SET;
	
	static {
		Set<Integer> tempSet = new HashSet<>(); 
		tempSet.add(123);
		tempSet.add(456);
		tempSet.add(789);
		ALLOWED_SET = Collections.unmodifiableSet(tempSet);
	}
	
	@Override
	public void validate()
	{
		if (!ALLOWED_SET.contains(userID))
		{
			addFieldError("userID", "Valid User ID is required");
		}
		if (StringUtils.isEmpty(userName))
		{
			addFieldError("userName", "Valid User name is required");
		}
	}
	@Override
	public String execute() throws Exception {
		setMessage("successful test");
		return SUCCESS;
	}


	private boolean validateInput(Integer userID, String userName) 
	{
		return ALLOWED_SET.contains(userID) && StringUtils.isNotEmpty(userName);
	}


	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * @return the userID
	 */
	public Integer getUserID() {
		return userID;
	}


	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
