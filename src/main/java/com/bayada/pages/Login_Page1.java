package com.bayada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bayada.base.BayadaMO_Base;

public class Login_Page1 extends BayadaMO_Base {
	
	@FindBy(id="okta-signin-username")     
	WebElement UserNameField;
	
	@FindBy(id="okta-signin-password")
	WebElement PasswordField;
	
	@FindBy(id="okta-signin-submit")
	WebElement ClickSignInButton;
	
	public Login_Page1() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		
		return driver.getTitle();
	}
	
	public void enterCredentialAndSignIn() throws InterruptedException {
		
		UserNameField.sendKeys(prop.getProperty("username"));
		Thread.sleep(4000);
		PasswordField.sendKeys(prop.getProperty("password"));
		Thread.sleep(4000);
		ClickSignInButton.click();
	}


}
