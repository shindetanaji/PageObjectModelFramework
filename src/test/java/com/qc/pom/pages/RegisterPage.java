package com.qc.pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "name")
	WebElement rName;
	
	@FindBy(id = "mobile")
	WebElement rMobile;
	
	@FindBy(id = "email")
	WebElement rEmail;
	
	@FindBy(id = "password")
	WebElement rPass;
	
	@FindBy(tagName = "button")
	WebElement rSubmit;
	
	public void enterName(String uName) {
		rName.clear();
		rName.sendKeys(uName);
	}
	
	public void enterMobile(String uMobile) {
		rMobile.clear();
		rMobile.sendKeys(uMobile);
	}
	
	public void enterEmail(String uEmail) {
		rEmail.clear();
		rEmail.sendKeys(uEmail);
	}
	
	public void enterPassword(String uPass) {
		rPass.clear();
		rPass.sendKeys(uPass);
	}
	
	public void clickOnSubmit() {
		rSubmit.click();
	}
	
	public void doRegisterWithValid(String uName, String uMobile, String uEmail, String uPass) {
		enterName(uName);
		enterMobile(uMobile);
		enterEmail(uEmail);
		enterPassword(uPass);
		clickOnSubmit();
	}
	
	public boolean verifyRegisterTitle() {
		String actResult = driver.getTitle();
		String expResult = "Queue Codes | Registration Page";
		return actResult.equals(expResult); 
	}
	
	public boolean verifyAlertMsg() {
		Alert alt = driver.switchTo().alert();
		String actResult = alt.getText();
		alt.accept();
		String expResult = "User registered successfully.";
		return actResult.equals(expResult);
	}
}
