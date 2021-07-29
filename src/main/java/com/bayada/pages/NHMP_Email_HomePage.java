package com.bayada.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bayada.base.BayadaMO_Base;

public class NHMP_Email_HomePage extends BayadaMO_Base {
	
	@FindBy(linkText = "Email")
	WebElement EmailButton;
	
	@FindBy(id = "MSOPageViewerWebPart_WebPartWPQ2")
	WebElement AR_frame;
	
	@FindBy(xpath = "//body/div[@id='dashboardBody']/div[2]/span[1]/span[1]/span[1]/input[1]")
	WebElement OfficeNumber;
	
	@FindBy(xpath = "//span[text()='Options'][1]")
	WebElement ScrollToOption;
	
	@FindBy(linkText = "Open Employee Form")
	WebElement OpenEmpButton;
	
	public NHMP_Email_HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickEmail() {
		ar_wait.until(ExpectedConditions.elementToBeClickable(EmailButton));
		EmailButton.click();
	}
	
	public void enterOfficeAndOpenEmpForm() throws InterruptedException {
		ar_wait.until(ExpectedConditions.elementToBeClickable(AR_frame));
		driver.switchTo().frame(AR_frame);
		ar_wait.until(ExpectedConditions.elementToBeClickable(OfficeNumber));
		OfficeNumber.clear();
		Thread.sleep(4000);
		OfficeNumber.sendKeys("439");
		Thread.sleep(2000);
		OfficeNumber.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		OfficeNumber.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ar_wait.until(ExpectedConditions.elementToBeClickable(ScrollToOption));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoView()", ScrollToOption);
		ScrollToOption.click();
		ar_wait.until(ExpectedConditions.elementToBeClickable(OpenEmpButton));
		OpenEmpButton.click();
		Thread.sleep(8000);
	}
	

}
