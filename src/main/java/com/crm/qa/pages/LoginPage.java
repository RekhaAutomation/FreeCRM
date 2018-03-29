package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
//page factory or OR(object repository)
	@FindBy(name="username")
	WebElement username;
	 @FindBy(name="password")
	 WebElement password;
	 @FindBy(xpath="//input[@value='Login']")
	 WebElement loginbutton;
	 @FindBy(xpath="//button[@class='btn']")
	 WebElement signupbutton;
	 @FindBy(xpath="//div[@class='navbar-header']//img[contains(@class,'img-responsive')]")
	 WebElement crmlogo;
	 //initializing page objects
public  LoginPage() {
	PageFactory.initElements(driver,this);
	
}
//actions
public String validateLoginpageTitle() {
	return driver.getTitle();
	
}
public boolean validateCRMImage() {
	return crmlogo.isDisplayed();
}
public HomePage login(String un,String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbutton.submit();
	return new HomePage();
}
}