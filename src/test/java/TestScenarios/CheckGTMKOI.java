package TestScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckGTMKOI {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://metroflooring.net/");
		
	}
	
	@Test(priority=0)
	public void verifyGTM() {
		
		//driver.getPageSource();
		Boolean gtm=driver.getPageSource().contains("(window,document,'script','dataLayer', 'GTM-");
		
		if(gtm){
			
			System.out.println("GTM 1st present");
		   
		}else {
			System.out.println("GTM 1st not present");
			
		}
		
		//WebElement igtm= driver.findElement(By.xpath("//iframe[contains[@src,'//www.googletagmanager.com/ns.html?id=GTM-']"));
		//www.googletagmanager.com/ns.html?id=GTM-
		Boolean igtm=driver.getPageSource().contains("//www.googletagmanager.com/ns.html?id=GTM-");
		if(igtm) {
			System.out.println("GTM 2nd present");
			
		}else {
			System.out.println("GTM 2nd not present");
		}
	}
		
		@Test(priority=1)
		public void verifyKOI() {
			
			Boolean koi=driver.getPageSource().contains("KOI-");
			
			if(koi) {
				
				System.out.println("KOI is present");
				
				
				
			}else {
				
				System.out.println("KOI is not present");
				
				
			}
			
			
			
			
			
		}
		
		

		
		
	
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
	

}
