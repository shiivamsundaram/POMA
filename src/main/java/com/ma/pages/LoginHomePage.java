package com.ma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ma.base.Page;

public class LoginHomePage extends Page{
	
	
	
	public MyAccountHomePage goToLogin(String username, String password)  {
		type("username_CSS",username);
		type("password_CSS",password);
		click("login_CSS");
		return new MyAccountHomePage();
		
	}
	
	
	
	public CreateAccountPage goToCreateAccount() {
		click("createaccount_CSS");
		return new CreateAccountPage();
		
	}
	
	public PasswordReoveryPage goToResetpassword() {
		click("resetpassword_CSS");
		return new PasswordReoveryPage();
		
	}
	
	public void login() {
		
		click("loginTop_XPATH");
		
	}
	
	public CreateAccountPage CreateAccount() {
		click("createaccountTop_XPATH");
		return new CreateAccountPage();
		
	}

}
