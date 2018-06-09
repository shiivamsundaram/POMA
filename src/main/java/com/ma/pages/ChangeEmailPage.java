package com.ma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ma.base.Page;

public class ChangeEmailPage extends Page {
	
	
	public void upDateEmail(String newEmail, String confirmEmail, String pswd) {
		
		type("newEmail_CSS",newEmail);
		type("confirmEmail_CSS",confirmEmail);
		type("pswd1_CSS",pswd);
		click("submit_CSS");
		
		
	}
	
	public void cancelUpdate() {
		click("cancelUpdate_CSS");
		
	}

}
