package markoSovilj.uipractice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class productSearch extends AbstractComponents{
	WebDriver driver;
	
	public productSearch(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".productName.css-j6g6xx")
	List <WebElement> specificProductLista;
	
	@FindBy (css = ".modifier-right")
	WebElement plus;
	
	@FindBy (css = ".quantity-display")
	WebElement numOfProducts;
	
	@FindBy (css = ".CartButton")
	WebElement addToBagBtn;
	
	@FindBy (xpath = "//p/b[1]")
	WebElement homePath;
	
	@FindBy (xpath = "//p/b[2]")
	WebElement productPath;
		
	@FindBy (id = "1")
	WebElement filterMicrosoft;
	
	@FindBy (css = "a img")
	WebElement companyLogo;
	
	@FindBy (xpath = "//a[6]")
	WebElement monitorBtn;
	
	
	
	public void laptopSelect(String laptopName) {
		Synhronization().until(ExpectedConditions.visibilityOfAllElements(specificProductLista));
		WebElement asus = specificProductLista.stream().filter(s->s.getText().contains(laptopName)).findFirst().orElse(null);
		asus.click();
	}
	
	public void laptopAddToBag() {
		Synhronization().until(ExpectedConditions.visibilityOf(numOfProducts));
		plus.click();		
		softAssert().assertEquals(numOfProducts.getAttribute("value"), "2");
		addToBagBtn.click();
		homePath.click();
	}
	
	public void controllerSelect() {
		Synhronization().until(ExpectedConditions.visibilityOfAllElements(specificProductLista));
		WebElement coreCont = specificProductLista.stream().filter(s->s.getText().contains("Core")).findFirst().orElse(null);
		coreCont.click();
	}
	public void controllerAddToBag() {
		Synhronization().until(ExpectedConditions.visibilityOfAllElements(numOfProducts));
		softAssert().assertEquals(numOfProducts.getAttribute("value"), "1");
		addToBagBtn.click();
		productPath.click();
		Synhronization().until(ExpectedConditions.visibilityOf(filterMicrosoft));
		filterMicrosoft.click();
		WebElement haloCont = specificProductLista.stream().filter(s->s.getText().contains("Halo")).findFirst().orElse(null);
		haloCont.click();
		addMoreProducts(plus, numOfProducts);
		addToBagBtn.click();
		companyLogo.click();
	}
	
	public void monitorSelect() {
		Synhronization().until(ExpectedConditions.visibilityOfAllElements(specificProductLista));
		WebElement monitor = specificProductLista.stream().filter(s->s.getText().contains("Samsung")).findFirst().orElse(null);
		monitor.click();
	}
	
	public CartPage monitorAddToBag() {
		Synhronization().until(ExpectedConditions.visibilityOf(addToBagBtn));
		addToBagBtn.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	
	
	
	
	
}
