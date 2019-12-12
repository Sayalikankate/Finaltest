package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver; // global so that rest of the classes can join
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebEventListener eventlistener;

	public TestBase() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sayali.sunil.kankate\\eclipse-workspace\\TestNG_POM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void initization() {
		String browserName = prop.getProperty("browser");
	//	String EmailName = "sayali151995@gmail.com";
		//System.out.println("");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sayali.sunil.kankate\\eclipse-workspace\\chromedriver.exe");
			driver = new ChromeDriver();
		}
			//else if (browserName == "FF") {
		//	System.setProperty("webdriver.gecko.driver",
		//			"C:\\Users\\sayali.sunil.kankate\\eclipse-workspace\\chromedriver.exe");
	//	}
		
		edriver= new EventFiringWebDriver(driver);
		eventlistener= new WebEventListener();
		edriver.register(eventlistener);
		driver = edriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		

		//driver.findElement(By.)
	}
	
	
}
