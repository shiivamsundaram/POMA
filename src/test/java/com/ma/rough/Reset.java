package com.ma.rough;

import com.ma.pages.CreateAccountPage;
import com.ma.pages.LoginHomePage;
import com.ma.pages.PasswordReoveryPage;

public class Reset {

	public static void main(String[] args) {
		
		LoginHomePage loginhome=new LoginHomePage();
	//	PasswordReoveryPage recovery=loginhome.goToResetpassword();
		//recovery.requestpswd("shiivamsundaram@gmail.com");
		CreateAccountPage create=loginhome.goToCreateAccount();
		create.createAccountPage("Mr", "shiivamsundaram", "sundaram", "abc@yahoo.com", "abc@yahoo.com", "Abcd1234", "Abcd1234", "What is the name of your first school?", "xyz");

	}

}
