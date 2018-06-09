package com.ma.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.ma.pages.CreateAccountPage;
import com.ma.pages.LoginHomePage;
import com.ma.pages.MyAccountHomePage;
import com.ma.utilities.Utilities;

public class CreateAccountTest {
	
	@Test(dataProviderClass=Utilities.class, dataProvider="dp" )
	public void createAccounttest(Hashtable<String, String> data) {
		LoginHomePage loginhome=new LoginHomePage();
		
		CreateAccountPage create= loginhome.CreateAccount();;
		
		create.createAccountPage(data.get("title"),data.get("fname"),data.get("lname"), data.get("email"), data.get("reemail"), data.get("pswd"), data.get("repswd"), data.get("secQust"), data.get("secAns"));
		
		
		
	}

}
