package TestScenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckNewCoupon {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://fleurysfloorcovering.com/");
		
		
		
	}
	
	@Test()
	public void verifyImage() {
		
		
	
		try {
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		//List<WebElement> listWithoutDuplicates = Lists.newArrayList(Sets.newHashSet(links));
		 System.out.println(links.size());
		 
		 for (int k=1; k<links.size();k++)
		 
		 {
			 String tagaurl=links.get(k).getAttribute("href");
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 System.out.println(tagaurl);
	//	 driver.get(tagaurl);
		 List<WebElement> allImages = driver.findElements(By.tagName("img"));
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 for(int n=0;n<allImages.size();n++){
		      String ImageUrl=allImages.get(n).getAttribute("src");
		      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		      if( ImageUrl.startsWith("https://")) {
			    	 
		    	  if(ImageUrl.endsWith(".jpg")) {
		    		  
		    		  if(!ImageUrl.endsWith("logo.jpg")) {
		    		  System.out.println(ImageUrl);
		    		  }
		    	  }
		      }
		    
		 }
		 
		 System.out.println("-----------------------------------------------------------");
		
		 }
		}catch(Exception e) {
			
			System.out.println("Exception"+ e);
			
		}
	
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}

}
