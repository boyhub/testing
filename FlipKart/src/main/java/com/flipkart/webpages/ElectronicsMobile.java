package com.flipkart.webpages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;

public class ElectronicsMobile extends TestBase {

	public ElectronicsMobile() {
		PageFactory.initElements(driver, this);
	}

//	Webelement initialization
	By ram4gb = By.xpath("//div[contains(text(),'4 GB')]");
	By brand = By.cssSelector("input._3vKPvR[placeholder='Search Brand']");
	By moto = By.xpath(
			"//div[@class='_4IiNRh _2mtkou'][@title='Motorola']/div/div/label/div[2][contains(text(),'Motorola')]");

//	Select 4Gb method
	public void select4GB() {
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(ram4gb));
		driver.findElement(ram4gb).click();
	}

//	Search Moto method
	public void search(String s) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(brand));
		driver.findElement(brand).clear();
		driver.findElement(brand).sendKeys(s);
	}

//	Select Motorola method
	public void selectMotorola() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(moto));
		driver.findElement(moto).click();
	}

//	Clear brand filters method
	public void clearFiltersFromBrand() {
		new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(moto));
		driver.findElement(moto).click();
	}

//	Verifying Moto tile
	public void verifyMotoTileText() {
		new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3wU53n']")));
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		for (int i = 0; i < list.size(); i++) {
//			int[] x = new int[2].clone();
//			x[i] = i;
			System.out.println(list.get(i).getText());
		}
		/*
		 * for (WebElement e : list) { System.out.println(e.getAttribute("innerText"));
		 * }
		 */
	}

//	Click on Moto G5 Plus (Lunar Grey, 32 GB) method
	public void selectMotoG5sLunarGrey32GB() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='_3wU53n'][contains(text(),'Moto G5s (Lunar Gray, 32 GB)')]")));
		driver.findElement(By.xpath("//div[@class='_3wU53n'][contains(text(),'Moto G5s (Lunar Gray, 32 GB)')]"))
				.click();
	}

//	PinCode change method
	public void enterDeliverPincode(String p) {
		new WebDriverWait(driver, 40)
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#pincodeInputId")));
		driver.findElement(By.cssSelector("input#pincodeInputId")).clear();
		driver.findElement(By.cssSelector("input#pincodeInputId")).sendKeys(p);
		driver.findElement(By.cssSelector("input#pincodeInputId")).sendKeys(Keys.ENTER);
	}

//	Mobile to cart method
	public void addMobileToCart() {
		new WebDriverWait(driver, 40)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button._2AkmmA._2Npkh4._2MWPVK")));
		driver.findElement(By.cssSelector("button._2AkmmA._2Npkh4._2MWPVK")).click();

	}
}
