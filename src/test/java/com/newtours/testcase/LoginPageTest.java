package com.newtours.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newtour.qa.pages.LoginPage;
import com.newtour.qa.pages.RegistrationPage;
import com.newtour.qa.testbase.TestBase;
import com.newtour.qa.utils.TestUtils;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	RegistrationPage registrationpage;
	TestUtils fileutils;
	
	public LoginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginpage= new LoginPage();	
		fileutils= new TestUtils();
	}
	
	
	@Test(priority=1)
	public void validateloginPageTitle() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}
	
	
	@Test(priority=2)
	public void CheckFindAFlightTextIsAvailable() {
		boolean result = loginpage.ValidateProperPageLoaded();
		System.out.println("Find a Flight text is " +result);
		
	}
	
	@Test(priority=3)
	public void ClickOnRegistrationButton() {
		loginpage.ClickOnRegistrationPage();
		System.out.println("clicked on the registration button");
	}
	
	
	
	
	
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	

}
