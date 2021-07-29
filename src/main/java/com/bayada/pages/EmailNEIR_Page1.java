package com.bayada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bayada.base.BayadaMO_Base;

public class EmailNEIR_Page1 extends BayadaMO_Base {

	
	@FindBy(xpath = "//input[@id='login']")
	WebElement EmailUsername;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement EmailPassword;
	
	@FindBy(xpath = "//input[@id='Log_On']")
	WebElement EmailLogOn;
	
	public EmailNEIR_Page1() {
		PageFactory.initElements(driver, this);
	}
	
	public void logOnToEmail() throws InterruptedException {
		ar_wait.until(ExpectedConditions.elementToBeClickable(EmailUsername));
		EmailUsername.sendKeys(prop.getProperty("emailusername"));
		Thread.sleep(2000);
		EmailPassword.sendKeys(prop.getProperty("emailpassword"));
		ar_wait.until(ExpectedConditions.elementToBeClickable(EmailLogOn));
		EmailLogOn.click();
		Thread.sleep(9000);
	}
}
