package com.bayada.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bayada.base.BayadaMO_Base;
import com.bayada.pages.EmailNEIR_Page1;
import com.bayada.pages.EmailNEIR_Page2;
import com.bayada.pages.EmailNEIR_Page3;
import com.bayada.pages.EmailNEIR_Page4;
import com.bayada.pages.Login_Page1;
import com.bayada.pages.NHMP_Email_HomePage;
import com.bayada.utility.TestUtil;

public class EmailNEIR_PageTest extends BayadaMO_Base {
	Login_Page1 log1;
	NHMP_Email_HomePage hp;
	EmailNEIR_Page1 ep1;
	EmailNEIR_Page2 ep2;
	EmailNEIR_Page3 ep3;
	EmailNEIR_Page4 ep4;
	TestUtil ut;
		
		public EmailNEIR_PageTest() {
			super();
		}

		@BeforeMethod
		public void seTup() {
			initialSteps();
			log1 = new Login_Page1();
			hp = new NHMP_Email_HomePage();
			ep1 = new EmailNEIR_Page1();
			ep2 = new EmailNEIR_Page2();
			ep3 = new EmailNEIR_Page3();
			ep4 = new EmailNEIR_Page4();
		}
		
			@Test(dataProvider="ManageOfficeTD")                                                       
			public void EmailNeirTest(String sub,String fn,String ln,String month,String date,String year,String ss,String add1,String city,String stat,String zeep) throws InterruptedException, IOException {
				log1.enterCredentialAndSignIn();
				hp.clickEmail();
				ep1.logOnToEmail();
				ep2.selectEmailAndClick(sub);
				ep3.enterDetailsInTheForm(fn,ln,month,date,year,ss,add1,city,stat,zeep);
				ep4.submitForm();
			}
			
			@DataProvider(name="ManageOfficeTD")
			public String [][] getData() throws IOException{
			String path = "D:\\Users\\arazzak\\eclipse-workspace\\BayadaMO-Automation\\src\\main\\java\\com\\bayada\\testdata\\MO TestData.xlsx";

			ut = new TestUtil(path);
			
			int totalrows = ut.getRowCount("EmailTD");
			int totalcols = ut.getCellCount("EmailTD", 1);
			
			String logData [][] =new String[totalrows][totalcols];
			
			for(int i=1;i<=totalrows; i++) {
				for(int j=0; j<totalcols; j++) {
					logData [i-1][j] = ut.getCellData("EmailTD", i, j);
				}
			}
			return logData;
			}
			
			@AfterMethod
			public void tearDown() {
				//driver.quit();
			}


}
