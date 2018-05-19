package com.newtour.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.qa.testbase.TestBase;

public class RegistrationPage extends TestBase {
	
	
	Logger log = Logger.getLogger(RegistrationPage.class); 
	
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@src='/images/masts/mast_register.gif']")
	WebElement ValidateRegistrationPage;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement EnterFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement EnterLastName;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement EnterPhoneNumber;
	
	@FindBy(xpath=".//*[@id='userName']")
	WebElement EnterEmail;
	
	@FindBy(xpath="//input[@name='address1']")
	WebElement EnterAddress;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement EnterCity;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement EnterState;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement EnterPostalCode;
	
	@FindBy(xpath="//option[@value='92']")
	WebElement EnterCountry;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement EnterUserName;
	
	@FindBy(xpath=".//*[@name='password']")
	WebElement EnterPassword;
	
	@FindBy(xpath=".//*[@name='confirmPassword']")
	WebElement EnterConfirmPassword;
	
	@FindBy(xpath="//input[@name='register']")
	WebElement ClickOnSubmitButton;
	
	@FindBy(xpath="//a[@href='mercurysignon.php']")
	WebElement VerifyRegistrationSuccessfulMessage;
	
	@FindBy(xpath="//a[@href='mercurysignon.php']")
	WebElement clickOnSignIn;
	
	
	public boolean VerifyRegistrationPage() {
		return ValidateRegistrationPage.isDisplayed();	
	}
	
	public void EnterFirstName(String FName) {
		EnterFirstName.sendKeys(FName);
	}
	
	public void EnterLastName(String LName) {
		EnterLastName.sendKeys(LName);
	}
	
	public void EnterPhoneNumber(String phone) {
		EnterPhoneNumber.sendKeys(phone);
	}
	
	public void EnterEmail(String Email) {
		EnterEmail.sendKeys(Email);
	}
	
	public void EnterAddress(String Address) {
		EnterAddress.sendKeys(Address);
	}
	
	public void EnterCity(String city) {
		EnterCity.sendKeys(city);
	}
	
	public void EnterState(String state) {
		EnterState.sendKeys(state);
	}
	
	public void EnterPostalCode(String pincode) {
		EnterPostalCode.sendKeys(pincode);
	}
	
	public void EnterCountry() {
		EnterCountry.click();
	}
	
	public void EnterUserName(String Usrname) {
		EnterUserName.sendKeys(Usrname);
	}
	
	public void EnterPassword(String Pass) {
		EnterPassword.sendKeys(Pass);
	}
	
	public void EnterConfirmPassword(String confpass) {
		EnterConfirmPassword.sendKeys(confpass);
	}
	
	public void ClickOnSubmitButton() {
		ClickOnSubmitButton.click();
	}
	
	public boolean VerifyRegistrationSuccessfulMessage() {
		return VerifyRegistrationSuccessfulMessage.isDisplayed();
	}
	
	public LoginPage ClickOnSignIn() {
		clickOnSignIn.click();
		return new LoginPage();
	}
	

	

}
