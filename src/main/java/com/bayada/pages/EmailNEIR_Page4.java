package com.bayada.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bayada.base.BayadaMO_Base;

public class EmailNEIR_Page4 extends BayadaMO_Base {
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement CheckBox;
	
	@FindBy(xpath = "//body/div[@id='content-container']/div[2]/div[7]/input[2]")
	WebElement SubmitButton;
	
	public EmailNEIR_Page4() {
		PageFactory.initElements(driver, this);
	}
	
	public void submitForm() throws InterruptedException {
		ar_wait.until(ExpectedConditions.elementToBeClickable(CheckBox));
		CheckBox.click();
		Thread.sleep(4000);
		//SubmitButton.click();
		
	}

}
