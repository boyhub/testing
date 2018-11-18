package com.flipkart.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.flipkart.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends TestBase {

	public Login() {
		PageFactory.initElements(driver, this);
	}

//	Page Elements Initialization
	By user = By.cssSelector("input[type='text']._2zrpKA");
	By pwd = By.cssSelector("input._2zrpKA._3v41xv");
	By login = By.cssSelector("button[class*='_2AkmmA _1LctnI _7UHT_c']>span");

//	Properties variable initialization for getting user credentials
//	Properties properties = new Properties();

	// OpenBrowser method
	public void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

//	Maximize browser method
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

//	Username field method
	public void enterEmailorMobile(String u) throws Exception {
//		properties.load(new FileReader(new File("userCredentials.properties")));
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(user)).clear();
		driver.findElement(user).sendKeys(prop.getProperty(u));
	}

//	Password field method
	public void enterPassword(String p) throws Exception {
//		properties.load(new FileReader(new File("userCredentials.properties")));
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys(prop.getProperty(p));
	}

//	Login button method
	public void clickLoginButton() {
		driver.findElement(login).click();
	}
}
