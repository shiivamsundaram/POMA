package com.ma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.ma.base.Page;

public class CreateAccountPage extends Page {
	
	
	public void createAccountPage(String title, String fname, String lname,String email, String reemail, String pswd, String repswd, String secQust, String secAns){
		
		select("title_CSS",title);
		type("fname_CSS",fname);
		type("lname_CSS",lname);
		type("email_CSS",email);
		type("reemail_CSS",reemail);
		type("pswd_CSS",pswd);
		type("repswd_CSS",repswd);
		select("secQust_CSS",secQust);
		type("secAns_CSS",secAns);
		click("checkbox_CSS");
		click("Registration_CSS");
	}

	
		
	}

	


