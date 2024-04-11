package markoSovilj.TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestComponents {
	
	
	
	public WebDriver Initialization() {
		WebDriverManager.chromedriver().setup();
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cloudtesting.contosotraders.com/");
		driver.manage().window().maximize();
		return driver;
	}

	
	
	
	
	
	
}
