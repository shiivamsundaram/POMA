package com.ma.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.ma.pages.ChangePasswordPage;
import com.ma.pages.LoginHomePage;
import com.ma.pages.MyAccountHomePage;
import com.ma.utilities.Utilities;

public class ChangePasswordTest {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void changePasswordTest(Hashtable<String,String> data) throws InterruptedException {
		MyAccountHomePage mahome=new MyAccountHomePage();
		ChangePasswordPage cpassword=mahome.goToChangePassword();
		cpassword.changePassword(data.get("pd"),data.get("newpd"),data.get("confirmpd"));
		mahome.goToLogout();
		LoginHomePage log=new LoginHomePage();
		//Thread.sleep(2000);
		log.CreateAccount();
		Thread.sleep(2000);
	}

}
