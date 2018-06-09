package com.ma.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.ma.pages.LoginHomePage;
import com.ma.pages.PasswordReoveryPage;
import com.ma.utilities.Utilities;

public class PasswordRecoveryTest {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void passwordRecoveryTest(Hashtable<String, String> data) throws InterruptedException {
		LoginHomePage loginhome=new LoginHomePage();
		loginhome.login();
		PasswordReoveryPage recover=loginhome.goToResetpassword();
		recover.requestpswd(data.get("username"));
		Thread.sleep(2000);
	}

}
