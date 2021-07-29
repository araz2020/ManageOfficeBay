package com.bayada.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bayada.base.BayadaMO_Base;
import com.bayada.pages.Login_Page1;
import com.bayada.pages.NHMP_Email_HomePage;

public class NHMP_Email_HomePageTest extends BayadaMO_Base {
Login_Page1 log1;
NHMP_Email_HomePage hp;

	
	public NHMP_Email_HomePageTest() {
		super();
	}

	@BeforeMethod
	public void seTup() {
		initialSteps();
		log1 = new Login_Page1();
		hp = new NHMP_Email_HomePage();
		
	}
	
		@Test                                                       
		public void loginTest() throws InterruptedException, IOException {
			
			log1.enterCredentialAndSignIn();
			hp.clickEmail();
			
			
			
		}
		
		@AfterMethod
		public void tearDown() {
			//driver.quit();
		}


}
