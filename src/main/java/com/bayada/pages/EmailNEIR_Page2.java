package com.bayada.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bayada.base.BayadaMO_Base;

public class EmailNEIR_Page2 extends BayadaMO_Base {
	
	@FindBy(xpath = "//div[@id='divSubject']")
	List<WebElement> AR_allemail;
	
	@FindBy(xpath = "//font[text()='click here']")
	WebElement ClickHereButton;
	
	
	
	public EmailNEIR_Page2() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectEmailAndClick(String sub) throws InterruptedException {
		
		System.out.println("Total email in inbox: "+AR_allemail.size());    
		for(WebElement ele: AR_allemail){
			String armail=ele.getText();
			if(armail.equalsIgnoreCase(sub)){
			ele.click();
			break;}}
		ar_wait.until(ExpectedConditions.elementToBeClickable(ClickHereButton));
		ClickHereButton.click();
		
		
	}

}
