package markoSovilj.uipractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class AbstractComponents {
WebDriver driver;

	public AbstractComponents(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "button[class*='fw-regular css-1bn4fjc']")
	WebElement dropdownBtn;
	
	@FindBy (xpath = "//span[text()='Laptops']")
	WebElement dropdownOption;
	
	@FindBy (xpath = "//a[@class='main-nav__item'] [text()='Controllers']")
	WebElement controllers;
	
	@FindBy (xpath = "//a[6]")
	WebElement monitors;
	
	
	public SoftAssert softAssert() {
		SoftAssert softara = new SoftAssert();
		return softara;
	}
	
	public WebDriverWait Synhronization() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait;
	}
	
	public void addMoreProducts(WebElement plus, WebElement numOfProducts) {
		Synhronization().until(ExpectedConditions.visibilityOf(plus));
		int numHaloCont = Integer.valueOf((numOfProducts).getAttribute("value"));
		 
		while(numHaloCont != 3) {
			
			plus.click();
			numHaloCont = Integer.valueOf((numOfProducts).getAttribute("value"));
		}
	}
	
	public void lapTopLocation() {
		dropdownBtn.click();
		dropdownOption.click();
	}
	
	public void controllersLocation() {
		controllers.click();
	}
	
	public void monitorsLocation() {
		monitors.click();
	}
}
