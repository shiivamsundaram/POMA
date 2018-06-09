package com.ma.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ma.pages.ChangeEmailPage;
import com.ma.pages.InvalidLoginPage;
import com.ma.pages.LoginHomePage;
import com.ma.pages.MyAccountHomePage;

public class LoginTest {

	public static void main(String[] args) {
		
	//	LoginHomePage loginhome=new LoginHomePage();
	//	MyAccountHomePage mahome=loginhome.goToLogin("shiivamsundaram@gmail.com", "Shivam123");
		//MyAccountHomePage mahome=new MyAccountHomePage();
	//	ChangeEmailPage changeemail=mahome.goToChangeEmail();
		//ChangeEmailPage changeemail=new ChangeEmailPage();
	//	changeemail.upDateEmail("shiivamsundaram@gmail.com", "shiivamsundaram@gmail.com", "Shivam123");
	//	mahome.goToLogout();
		
	//invalidloginpage	
		
		InvalidLoginPage loginhome=new InvalidLoginPage();
		//loginhome.pswdvalidation("shiivamsundaram@gmail.com", "");
		//loginhome.emailvalidation("", "Shivam123");
		loginhome.validvalidation("", "");
		

	}

}
