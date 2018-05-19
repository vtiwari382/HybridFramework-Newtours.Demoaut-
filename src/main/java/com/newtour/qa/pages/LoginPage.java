package com.newtour.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.qa.testbase.TestBase;

public class LoginPage extends TestBase{
	
	Logger log = Logger.getLogger(LoginPage.class); 
	
	
	@FindBy(xpath="//img[@alt='Find a Flight']")
	WebElement ValidateTheLoginPage;
	
	@FindBy(xpath="html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
	WebElement clickOnRegister;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement EnteruserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement EnterPassword;
	
	@FindBy(xpath="//input[@name='login'][@value='Login']")
	WebElement ClickOnSubmitButton;
	
// Initializing the page object	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean ValidateProperPageLoaded() {
		return ValidateTheLoginPage.isDisplayed();
	}
	
	public RegistrationPage ClickOnRegistrationPage() {
		clickOnRegister.click();
		return new RegistrationPage();
	}
	
	public void EnterUIDAndPass(String UName, String Pass) {
		EnteruserName.sendKeys(UName);
		EnterPassword.sendKeys(Pass);
		ClickOnSubmitButton.click();
	}
	
	

}
