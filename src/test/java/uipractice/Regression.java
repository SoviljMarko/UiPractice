package uipractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;

import markoSovilj.TestComponents.TestComponents;
import markoSovilj.uipractice.CartPage;
import markoSovilj.uipractice.productSearch;

public class Regression extends TestComponents{
	
	WebDriver driver;
	
	@Test
	public void mainTest() {
				
		productSearch productsearch = new productSearch(driver);
		productsearch.lapTopLocation();
		productsearch.laptopSelect("F15");		
		productsearch.laptopAddToBag();
		
		productsearch.controllersLocation();
		productsearch.controllerSelect();
		productsearch.controllerAddToBag();
				
		
		productsearch.monitorsLocation();
		productsearch.monitorSelect();
		CartPage cartPage = productsearch.monitorAddToBag();
		
		cartPage.goToCartPage();
		cartPage.selectedProductsCheck();
		cartPage.priceCompare();
		
		
		
		
		
	}
	
	@BeforeTest
	public void begin() {
		
		driver = Initialization();
	}
	
	@AfterTest
	public void finish() {
		driver.close();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertAll();
	}
}
