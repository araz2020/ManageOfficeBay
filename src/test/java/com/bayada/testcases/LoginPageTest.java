package com.bayada.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bayada.base.BayadaMO_Base;
import com.bayada.pages.Login_Page1;

public class LoginPageTest extends BayadaMO_Base {
	Login_Page1 log1;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void seTup() {
		initialSteps();
		log1 = new Login_Page1();
	}
	
		@Test                                                       
		public void loginTest() throws InterruptedException, IOException {
			
			log1.enterCredentialAndSignIn();
			
			
		}
		
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}

}
