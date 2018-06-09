package com.ma.testcases;

import org.testng.annotations.AfterSuite;

import com.ma.base.Page;

public class BaseTest {
	@AfterSuite
	public void tearDown() {
	 Page.quit();
		
	}

}
