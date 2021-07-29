package com.bayada.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bayada.base.BayadaMO_Base;

public class FormNEIR_Page1 extends BayadaMO_Base {
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
	
	public FormNEIR_Page1() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetailsInTheForm() throws InterruptedException {
		String currentwindow=driver.getWindowHandle();
		System.out.println(currentwindow);
		System.out.println("This is Form NEIR page");
		
		Set<String> setwin =driver.getWindowHandles();
		
		Iterator<String> itr= setwin.iterator();
		while(itr.hasNext()){
			String child1=itr.next();
	    if(!currentwindow.equals(child1)) {   
			driver.switchTo().window(child1);
			driver.manage().window().maximize();
			//Thread.sleep(4000);
			ar_wait.until(ExpectedConditions.elementToBeClickable(FirstName));
			FirstName.sendKeys("Raz");
			Thread.sleep(2000);
			LasttName.sendKeys("Ayan");
			Thread.sleep(2000);
			BirthMonth.sendKeys("12");
			Thread.sleep(2000);
			BirthDay.sendKeys("21");
			Thread.sleep(2000);
			BirthYear.sendKeys("1994");
			Thread.sleep(2000);
			SSN.sendKeys("469852369");
			Thread.sleep(2000);
			AddressOne.sendKeys("4300 Haddonfield Road");
			Thread.sleep(2000);
			City.sendKeys("Pennsauken");
			Thread.sleep(2000);
			ChooseState.click();
			Thread.sleep(4000);

			System.out.println("Available states: " +AllStates.size());

			for (WebElement ele : AllStates) {
				String state = ele.getText();
				if (state.equalsIgnoreCase("New Jersey")) {
					ele.click();
					break;
				}
			}
			ZipCode.sendKeys("08109");
			Thread.sleep(2000);
			ReviewButton.click();
			
			break;
			} }
		
	}

}
