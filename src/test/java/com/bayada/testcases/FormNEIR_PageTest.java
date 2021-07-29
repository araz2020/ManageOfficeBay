package com.bayada.testcases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bayada.base.BayadaMO_Base;
import com.bayada.pages.FormNEIR_Page1;
import com.bayada.pages.FormNEIR_Page2;
import com.bayada.pages.Login_Page1;
import com.bayada.pages.NHMP_Email_HomePage;

public class FormNEIR_PageTest extends BayadaMO_Base {
	Login_Page1 log1;
	NHMP_Email_HomePage hp;
	FormNEIR_Page1 fn1;
	FormNEIR_Page2 fn2;
		
		public FormNEIR_PageTest() {
			super();
		}

		@BeforeMethod
		public void seTup() {
			initialSteps();
			log1 = new Login_Page1();
			hp = new NHMP_Email_HomePage();
			fn1 = new FormNEIR_Page1();
			fn2 = new FormNEIR_Page2();
			
		}
		
			@Test                                                       
			public void formTest() throws InterruptedException, IOException {
				
				log1.enterCredentialAndSignIn();
				hp.enterOfficeAndOpenEmpForm();
				fn1.enterDetailsInTheForm();
				fn2.submitForm();
				
				
			}
			
			@AfterMethod
			public void tearDown() {
				//driver.quit();
			}

}
