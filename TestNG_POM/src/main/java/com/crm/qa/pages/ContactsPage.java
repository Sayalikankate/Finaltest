package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//span[@class='item-text' and contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newContactButton;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement companyName;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@name='channel_type']")
	WebElement dropDownclick;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactslabel() {
		return contactLabel.isDisplayed();
	}
	
	public void clickOnnewContact() {
		contactLabel.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public void createNewContact(String fname, String lname, String category) throws InterruptedException {
		newContactButton.click();
		firstName.sendKeys(fname);
		LastName.sendKeys(lname);
		
		
		 TestUtil.scrollfunction();
		 TestUtil.waitfunction();
		dropDownclick.click();
		
		String xpathwithVariable= "//div[@class='visible menu transition']//span[@class='text' and text()='"+category+"']";
		
		driver.findElement(By.xpath(xpathwithVariable)).click();
		
		saveButton.click();
		Thread.sleep(2000);
		
	}
}


