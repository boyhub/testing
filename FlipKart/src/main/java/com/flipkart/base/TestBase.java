package com.flipkart.base;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			prop.load(new FileReader(new File("userCredentials.properties")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openBrowser(String b) {
		if (b.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (b.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Not the proper browser");
		}
	}

	public void maxiMizeAndClearCookies() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

//	InputeURL method
	public void inputURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.quit();
	}

//	Switching Tabs method
	public void switchToNextTab() throws Exception {
		String oldTab = driver.getWindowHandle();
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		tab.remove(oldTab);
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(tab.get(0));
	}

}
