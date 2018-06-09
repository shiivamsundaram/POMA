package com.ma.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.ma.pages.ChangeEmailPage;
import com.ma.pages.MyAccountHomePage;
import com.ma.utilities.Utilities;

public class ChangeEmailTest {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	
	public void changeEmailTest(Hashtable<String, String> data) throws InterruptedException {
		
		MyAccountHomePage mahome=new MyAccountHomePage();
		ChangeEmailPage cmail=mahome.goToChangeEmail();
		cmail.upDateEmail(data.get("newEmail"), data.get("confirmEmail"), data.get("pswd"));
		mahome.goToMyAccount();
		Thread.sleep(2000);
	}

}
