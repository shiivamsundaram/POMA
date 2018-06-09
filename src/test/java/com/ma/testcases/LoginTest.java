package com.ma.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.ma.pages.LoginHomePage;
import com.ma.pages.MyAccountHomePage;
import com.ma.utilities.Utilities;

public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass=Utilities.class, dataProvider="dp")
	public void logintest(Hashtable<String, String> data) {
		LoginHomePage loginhome=new LoginHomePage();
		MyAccountHomePage mahome=loginhome.goToLogin(data.get("userName"), data.get("pswd"));
		//mahome.goToLogout();
		
	}

}
