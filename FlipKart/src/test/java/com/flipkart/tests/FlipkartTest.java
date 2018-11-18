package com.flipkart.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.flipkart.base.ScreenShots;
import com.flipkart.base.TestBase;
import com.flipkart.webpages.ElectronicsMobile;
import com.flipkart.webpages.HomePage;
import com.flipkart.webpages.Login;

public class FlipkartTest extends TestBase {
//	Creating objects
	Login login = new Login();
	HomePage homePage = new HomePage();
	ElectronicsMobile ram = new ElectronicsMobile();
	ScreenShots capture = new ScreenShots();
	ElectronicsMobile mobilePage = new ElectronicsMobile();

	public FlipkartTest() {
		super();
	}

// Open Browser and Clear all cookies
	@BeforeTest
	public void before() {
//		we can give "chrome"  or "firefox"
		openBrowser("chrome");
		maxiMizeAndClearCookies();
	}

//	Test Case
	@Test
	public void flipKart() throws Exception {
		inputURL("https://www.flipkart.com");
		login.enterEmailorMobile("email");
		login.enterPassword("password");
		login.clickLoginButton();
//		Throwing ALERT for confirming Homepage and it’s top menu has “Electronics” as an entry
		homePage.verifyHomePageByThrowingAlert();
		homePage.clickElectronics();
		homePage.navigateToMobiles();
		ram.select4GB();
//		Capturing screenshot to verify filtered list contains first 2 items which has “4 GB” in its description
		capture.screenShot();
		mobilePage.search("Moto");
//		Capturing screenshot to verify the checkbox Motorola is there
		capture.screenShot();
		mobilePage.selectMotorola();
		mobilePage.verifyMotoTileText();
		mobilePage.clearFiltersFromBrand();
		homePage.search("Moto G5s (Lunar Gray, 32 GB)");
		mobilePage.selectMotoG5sLunarGrey32GB();
		switchToNextTab();
		mobilePage.enterDeliverPincode("641018");
		mobilePage.addMobileToCart();
	}

	@AfterTest
	public void after() {
//		driver.quit();
	}
}