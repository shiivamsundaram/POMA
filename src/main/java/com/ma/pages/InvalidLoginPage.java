package com.ma.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.ma.base.Page;

public class InvalidLoginPage extends Page {
	
	public void pswdvalidation(String username, String password) {
		type("username_CSS",username);
		type("password_CSS",password);
		click("login_CSS");
		String expected=gettext("uservalidation_XPATH");
		System.out.println(expected);
		Assert.assertEquals("Please enter your password", expected);
	}
	
	public void emailvalidation(String username, String password) {
		type("username_CSS",username);
		type("password_CSS",password);
		click("login_CSS");
		String expected=gettext("emailvalidation_XPATH");
		System.out.println(expected);
		Assert.assertEquals("Please enter your email address", expected);
	}
	
	public void validvalidation(String username, String password) {
		type("username_CSS",username);
		type("password_CSS",password);
		click("login_CSS");
		String expected=gettext("uservalidation_XPATH");
		String expected2=gettext("emailvalidation_XPATH");
		Assert.assertEquals("Please enter your email address", expected +  "Please enter your password", expected2);
	}
}
