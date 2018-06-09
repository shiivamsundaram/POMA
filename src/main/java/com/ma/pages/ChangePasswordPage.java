package com.ma.pages;

import com.ma.base.Page;

public class ChangePasswordPage extends Page {
	
	public void changePassword(String pd,String newpd, String confirmpd) {
		type("currentpd_XPATH",pd);
		type("newpd_XPATH",newpd);
		type("confirmnewpd_XPATH",confirmpd);
		click("changebtn_XPATH");
		
		
		
		
	}

}
