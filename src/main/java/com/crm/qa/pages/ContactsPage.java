package com.crm.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;
	
	@FindBy(xpath="//input[@value='Show Full Form']")
	WebElement fullFormBtn;
	
	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement saveBtn;
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContact(String title,String ftName, String ltName, String comp)
	{
		Select s=new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		while(!((firstName.getText().equalsIgnoreCase(ftName))&&(lastName.getText().equalsIgnoreCase(ltName))))
		{
			firstName.sendKeys(ftName);
			lastName.sendKeys(ltName);
			company.sendKeys(comp);
			saveBtn.click();
			break;
		}
		
		//lastName.sendKeys(ltName);
		//company.sendKeys(comp);
		//saveBtn.click();
	}
	/*public void selectContactsByName(String name)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
		+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact-id']")).click();
	}*/
}
