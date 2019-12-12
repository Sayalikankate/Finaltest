package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[text()='Sayali Kankate']")
	WebElement usernamevalidation;
	
	@FindBy(xpath="//span[text()='Calendar']")
	WebElement calendar;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contact;
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement usernameLabel;

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyhomepageTitleTest() {
		return driver.getTitle();
	}
	
	
	
	public CalendarPage clickCalendar() {
		calendar.click();
		return  new CalendarPage();
	}
	
	public ContactsPage clickContacts() {
		calendar.click();
		return  new ContactsPage();
	}

	public boolean verifyUsernameLabel() {
		return usernameLabel.isDisplayed();
		
	}
	
	

}
