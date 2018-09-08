package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// DEFINING PAGE LIBRARIES,PAGE FACTORY OR OBJECT REPOSITORY
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@class='btn btn-small']")
	WebElement loginBtn;

	@FindBy(xpath = "//font[contains(text(),'Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

	// Now create the method
	// How to initialize the elements with the help of page factory
	// Create a constructor of LoginPage Class
	// Initializing the page objects

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) { 
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", loginBtn);

		// loginBtn.click();
		return new HomePage(); // This method is returning HomePage class object
	}// now we will create a testcase for LoginPage class inside the test package
}
