package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FullFormPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	//FullFormPage fullFormPage;
	 public ContactsPageTest()
	 {
		 super();
	 }
	 
	@BeforeMethod
	 public void setUp()
	 {
		 initialization();
		 loginPage = new LoginPage();
		// homePage = new HomePage();
		 testUtil = new TestUtil();
		 //fullFormPage = new FullFormPage();
		 contactsPage = new ContactsPage();
		 homePage =loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 testUtil.switchToFrame();
		 contactsPage = homePage.clickOnContactsLink();
	 }
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts Label is missing on the page");
	}
    @DataProvider
    public Object[][] getCRMTestData()
    {
    	Object data[][]=TestUtil.getTestData(sheetName);
    	return data;
    }
    
	@Test(priority=2,dataProvider ="getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company)
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	/*public void selectSingleContactsTest()
	{
		contactsPage.selectContactsByName("Tom Hogan");
	}*/
}

