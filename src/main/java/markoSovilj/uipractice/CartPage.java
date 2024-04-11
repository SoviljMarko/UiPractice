package markoSovilj.uipractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".iconButton.css-1deacqj")
	WebElement cartBtn;
	
	@FindBy (css = ".Productname.css-15j76c0")
	List <WebElement> allProducts;
	
	@FindBy (xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-2 MuiGrid-grid-lg-2 Productprice css-r7calx'] [3]")
	List <WebElement> tabeleSum;
	
	@FindBy (css = ".OrderSubPrice.css-o0rlmm")
	WebElement subTotal;
	
	
	
	public void goToCartPage() {
		cartBtn.click();
	}
	
	public void selectedProductsCheck() {
		softAssert().assertEquals("ASUS TUF Gaming F15 (2021), 15.6\\\\\\\" (39.62 cms) FHD 144Hz Laptop", 
				allProducts.stream().filter(s->s.getText().contains("F15")).findFirst().orElse(null).getText());
		softAssert().assertEquals(allProducts.stream().filter(s->s.getText().contains("Core")).findFirst().orElse(null).getText(),
				"Xbox Elite Wireless Controller Series 2 Core (White)");
		softAssert().assertEquals(allProducts.stream().filter(s->s.getText().contains("Halo")).findFirst().orElse(null).getText(),
				"Xbox Elite Wireless Controller Series 2 Halo Infinite Limited Edition");
		softAssert().assertEquals(allProducts.stream().filter(s->s.getText().contains("Samsung")).findFirst().orElse(null).getText(),
				"Samsung 24-inch(60.46cm) FHD Monitor");
	}
	
	public void priceCompare() {
		List<String> zbirLista =  tabeleSum.stream().map(s->s.getText()).collect(Collectors.toList());
		int konvertovaniStringovi = 0;
		
		for(int i = 0; i < zbirLista.size(); i++) { 
			konvertovaniStringovi += Integer.valueOf(zbirLista.get(i).replace("$", "").replace(".00", ""));
		}
			
		String subTotalString = subTotal.getText();
		int subTotalInt = Integer.valueOf(subTotalString.replace("$", "").replace(".00", ""));
		
		softAssert().assertEquals(konvertovaniStringovi, subTotalInt);
	}
	
}
