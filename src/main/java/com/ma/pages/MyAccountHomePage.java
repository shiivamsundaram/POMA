package com.ma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ma.base.Page;

public class MyAccountHomePage extends Page {
		
	public ChangeEmailPage goToChangeEmail() {
		click("changeemail_XPATH");
		return new ChangeEmailPage();
	}
	public ChangePasswordPage goToChangePassword() {
		click("changepassword_XPATH");
		return new ChangePasswordPage();
		
	}
	
	public void goToDeactivateAccount() {
	click("deactivate_XPATH");
		
	}
	
	public void goToLogout() {
		click("logout_XPATH");
	}
	
	public void goToMyAccount() {
		click("myaccount_XPATH");
	}

}
