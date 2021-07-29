package com.bayada.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bayada.base.BayadaMO_Base;

public class EmailNEIR_Page3 extends BayadaMO_Base {
	
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement LasttName;
	
	@FindBy(xpath = "//input[@name='birthdatemonth']")
	WebElement BirthMonth;
	
	@FindBy(xpath = "//input[@name='birthdateday']")
	WebElement BirthDay;
	
	@FindBy(xpath = "//input[@name='birthdateyear']")
	WebElement BirthYear;
	
	@FindBy(xpath = "//input[@id='ssn']")
	WebElement SSN;
	
	@FindBy(xpath = "//input[@name='address1']")
	WebElement AddressOne;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath = "//span[text()='Choose a State']")
	WebElement ChooseState;
	
	@FindBy(xpath = "//div[@class='k-list-scroller']/ul/li")
	List<WebElement> AllStates;
	
	@FindBy(xpath = "//input[@name='zip']")
	WebElement ZipCode;
	
	@FindBy(xpath = "//body/div[@id='content-container']/div[1]/input[1]")
	WebElement ReviewButton;
	
	public EmailNEIR_Page3() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetailsInTheForm(String fn,String ln,String month,String date,String year,String ss,String add1,String city,String stat,String zeep) throws InterruptedException {
		String currentwindow=driver.getWindowHandle();
		System.out.println(currentwindow);
		System.out.println("This is Email Inbox page");
		
		Set<String> setwin =driver.getWindowHandles();
		
		Iterator<String> itr= setwin.iterator();
		while(itr.hasNext()){
			String child1=itr.next();
	    if(!currentwindow.equals(child1)) {   
			driver.switchTo().window(child1);
			driver.manage().window().maximize();
			ar_wait.until(ExpectedConditions.elementToBeClickable(FirstName));
			FirstName.sendKeys(fn);
			Thread.sleep(2000);
			LasttName.sendKeys(ln);
			Thread.sleep(2000);
			BirthMonth.sendKeys(month);
			Thread.sleep(2000);
			BirthDay.sendKeys(date);
			Thread.sleep(2000);
			BirthYear.sendKeys(year);
			Thread.sleep(2000);
			SSN.sendKeys(ss);
			Thread.sleep(2000);
			AddressOne.sendKeys(add1);
			Thread.sleep(2000);
			City.sendKeys(city);
			Thread.sleep(2000);
			ChooseState.click();
			Thread.sleep(4000);

			System.out.println("Available states: " +AllStates.size());

			for (WebElement ele : AllStates) {
				String state = ele.getText();
				if (state.equalsIgnoreCase(stat)) {
					ele.click();
					break;
				}
			}
			ZipCode.sendKeys(zeep);
			Thread.sleep(2000);
			ReviewButton.click();
			
			break;
			} }
		
	}

}
