package com.newtours.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.qa.pages.LoginPage;
import com.newtour.qa.pages.RegistrationPage;
import com.newtour.qa.testbase.TestBase;
import com.newtour.qa.utils.TestUtils;

public class RegistrationPageTest extends TestBase {

	LoginPage loginpage;
	RegistrationPage registration;
	TestUtils utils;
	
	public RegistrationPageTest() {
		super();
	}
	
	
	@BeforeClass
	public void Setup() {
		initialization();
		loginpage = new LoginPage();
		registration = new RegistrationPage();
		utils = new TestUtils();
		
	}
	
	
	
	@Test(priority=1)
	public void ClickOnRegistrationbutton() {
		loginpage.ClickOnRegistrationPage();
	}
	
	
	@Test(priority=2)
	public void ValidateRegistrationPageLoaded() {
		registration.VerifyRegistrationPage();
	}
	
	
	@DataProvider
	public Object[][] getDemoutTourTestData() {
		Object[][] data = utils.GetTestData("Registration");
		return data;
		
	}
	
	@Test(priority=3, dataProvider="getDemoutTourTestData")
	public void FillRegistrationForm(String FName, String LName, String phone, String Email, String Address, String city, String state
			, String pincode, String Usrname, String Pass, String confpass) {
		registration.EnterFirstName(FName);
		registration.EnterLastName(LName);
		registration.EnterPhoneNumber(phone);
		registration.EnterEmail(Email);
		registration.EnterAddress(Address);
		registration.EnterCity(city);
		registration.EnterState(state);
		registration.EnterPostalCode(pincode);
		registration.EnterCountry();
		registration.EnterUserName(Usrname);
		registration.EnterPassword(Pass);
		registration.EnterConfirmPassword(confpass);
	}
	
	
	
	
	@AfterClass
	public void TearOut() {
//		driver.close();
	}
	
	
}
