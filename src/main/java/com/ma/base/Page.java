package com.ma.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ma.utilities.ExcelReader;
import com.ma.utilities.ExtentManager;
import com.ma.utilities.Utilities;

public class Page {
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\ma\\excel\\MATestData.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	
	public Page() {
		if(driver==null) {
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\ma\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\ma\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Jenkinns browser setup		
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
				browser=System.getenv("browser");
			}else
				{
				browser=config.getProperty("browser");
				
			}
			config.setProperty("browser", browser);
			//end for Jenkins
			
			if(config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\com\\ma\\executables\\geckodriver.exe");
				driver=new FirefoxDriver();
			}else if(config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\com\\ma\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
			log.debug("chrome launched");
			
		}
			
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
		//driver=new FirefoxDriver();
			driver.get(config.getProperty("testsiteurl"));
			log.debug("navigated to :"+(config.getProperty("testsiteurl")));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;	
			wait=new WebDriverWait(driver,5);
		
		}
	}
	public static void quit() {
		driver.quit();
	}
	
	public void click(String locator) {
		
		if(locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}else if(locator.endsWith("_ID")) {
		driver.findElement(By.id(OR.getProperty(locator))).click();
}
		log.debug("Clicking on an element :"+locator);
		test.log(LogStatus.INFO, "clicking on  :"+locator);
	}
	static String a;
public String gettext(String locator) {
		
		if(locator.endsWith("_CSS")) {
		 a=driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
		}else if(locator.endsWith("_XPATH")) {
			 a=driver.findElement(By.xpath(OR.getProperty(locator))).getText();
	}else if(locator.endsWith("_ID")) {
		 a=driver.findElement(By.id(OR.getProperty(locator))).getText();
}
		return a;
}
	public void type(String locator, String value) {
		
		if(locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);	
		}else if(locator.endsWith("_ID")) {	
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);	
		}
		log.debug("typing in an element :"+locator+"entered value as :"+value);
		test.log(LogStatus.INFO, "Typing in :"+locator+" entered value "+value);
	}

	static WebElement dropdown;
	public void select(String locator, String value) {
		if(locator.endsWith("_CSS")) {
			dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
			}else if(locator.endsWith("_XPATH")) {
				dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));	
			}else if(locator.endsWith("_ID")) {	
				dropdown=driver.findElement(By.id(OR.getProperty(locator)));
							}
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("Selecting from an element : "+locator+ " value as :"+value);
		test.log(LogStatus.INFO, "Selecting from dropdown :"+locator+" value as "+value);
	}
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
		return false;
	}
	}
	public static void verifyEquals(String expected, String actual) throws IOException  {
		try {
			Assert.assertEquals(actual, expected);
			
		}
		catch(Throwable t){
			Utilities.captureScreenshot();
			//reportNG
			Reporter.log("<br>"+"verification failure :"+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			//Extent Report
			test.log(LogStatus.FAIL,"verification failure :"+t.getMessage());
			test.log(LogStatus.FAIL,test.addScreenCapture(Utilities.screenshotName));
			
		}
	}
}
