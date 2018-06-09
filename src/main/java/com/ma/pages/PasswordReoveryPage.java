package com.ma.pages;

import org.openqa.selenium.By;

import com.ma.base.Page;

public class PasswordReoveryPage extends Page{
	
	public void requestpswd(String username) {
	
	type("emailtext_XPATH",username);	
	click("btnRecovery_XPATH");
	click("btnclose_XPATH");
	
}
}
