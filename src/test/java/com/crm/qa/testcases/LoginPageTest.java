package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;   //created reference variable
    HomePage homepage;
    public LoginPageTest()
    {
    	super();  //super keyword will call superclass constructor
    }
    
    @BeforeMethod
    public void setUp()
    {
    	initialization();
    	loginpage=new LoginPage();  //we created an object of LoginPage class
    }
    
   /* @Test(priority=1)
    public void loginPageTitleTest()
    {
    	String title= loginpage.validateLoginPageTitle();
    	Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
    }
    
    @Test(priority=2)
    public void crmlogoImageTest()
    {
    	boolean flag=loginpage.validateCRMImage();
    	Assert.assertTrue(flag);
    }*/
    
    @Test(priority=3)
    public void loginTest()
    {
    	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    @AfterMethod
    public void tearDown()
    {
    	driver.quit();
    }
}
