package com.newtour.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.newtour.qa.pages.LoginPage;
import com.newtour.qa.utils.TestUtils;

public class TestBase {
	
	public static Properties prop;
	public static FileInputStream file;
	public static WebDriver driver;
	
	
	Logger log = Logger.getLogger(TestBase.class); 
	
	
	public TestBase() {
		try {
		 prop = new Properties();
		
		file = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\"
					+ "newtour\\qa\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browsertype = prop.getProperty("browser");
		
		if(browsertype.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver", ".\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browsertype.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver", "/Browser/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
