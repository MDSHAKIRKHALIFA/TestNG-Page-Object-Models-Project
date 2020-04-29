package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.Testutil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties proper;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;

	public TestBase() {
		try {
			proper = new Properties();
			FileInputStream fi = new FileInputStream("/Users/shakir/eclipse-workspace2/My_TestNG/src/main/java/com/crm/qa/configuration/config.properties");
			proper.load(fi);	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	public static void initialization() {
		String browserName = proper.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/shakir/Desktop/All-Drivers/chromedriver");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/shakir/D/All-Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		
		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver = eventDriver ;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(proper.getProperty("url"));
	}
}
//Shakir
