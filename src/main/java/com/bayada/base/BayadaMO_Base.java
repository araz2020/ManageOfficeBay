package com.bayada.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BayadaMO_Base {
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait ar_wait;
	
	public BayadaMO_Base() {
		
	try {
	prop = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//com//bayada//config//Bay_MO_Config.properties");
	prop.load(ip);
		
		} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialSteps() {
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\arazzak\\Documents\\Abdur R Docs\\Abdurs_Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\FireFoxDriver\\geckodriver.exe");
			  driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		ar_wait = new WebDriverWait(driver, 40);
		
		
		
	}

}
