package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
//@CacheLookup
/*improves the performance of the test script
//need not to hit the browser every time to locate the element
//There is a chance to get  StaleElementException when a page is refreshed.*/	
@FindBy(xpath ="//td[contains(text(),'User: Rekha Ganib ')]")
	WebElement userNameLable;
	@FindBy(linkText = "CONTACTS")
	WebElement contactsLink;
	@FindBy(linkText = "Deals")
	WebElement dealsLink;
	@FindBy(linkText = "Tasks")
	WebElement tasksLink;
@FindBy(xpath="//a[text()='New Contact']")
WebElement newContactLink;
	public HomePage() {
		// initializing objects
		PageFactory.initElements(driver, this);

	}

	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUsername() {
		return userNameLable.isDisplayed();
	}

	public ContactsPage clickOncontactsLink() {

		contactsLink.click();
		return new  ContactsPage();

	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();

	}
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		//always use build().perform() with action class
		action.moveToElement(contactsLink).build().perform();
		//action.moveToElement(newContactLink).click().build().perform();
		newContactLink.click();
		
	}
}

