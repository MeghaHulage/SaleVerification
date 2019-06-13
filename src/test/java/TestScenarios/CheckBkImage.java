package TestScenarios;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBkImage {
WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://premierefloorsdc-stg.mm-dev.agency/");
		
		
		
	}
	
	@Test()
	public void verifyImage() {
		
		
	
		try {
		
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		//List<WebElement> listWithoutDuplicates = Lists.newArrayList(Sets.newHashSet(links));
		 System.out.println(links.size());
		 
		 for (int k=1; k<links.size();k++)
		 
		 {
			 
			 String tagaurl=links.get(k).getAttribute("href");
			// driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		 System.out.println(tagaurl);
		 
		 System.out.println("**************************************************************");
		 driver.navigate().to(tagaurl);
		 Thread.sleep(3000);
		 
		 if(tagaurl.startsWith("https://premierefloorsdc")) {
			 
			
		
		  
		 List<WebElement> allImages = driver.findElements(By.tagName("img"));
		
		// HashSet<WebElement> hashSet = new HashSet(allImages);  
	
		 for(int n=0;n<allImages.size();n++){
			 
		      String ImageUrl=allImages.get(n).getAttribute("src");
		     
		      if( ImageUrl.startsWith("https://")) {
			    	 
		    	  if(ImageUrl.endsWith(".jpg")) {
		    		  
		    		  if(!ImageUrl.endsWith("logo.jpg")) {
		    			
		    		  //System.out.println(ImageUrl);
		    		  
		    		  String[] fullUrlAry1 = ImageUrl.split("/");
						
						Integer fullUrlAryLen2 = fullUrlAry1.length;
						
						String fullImageName3 = fullUrlAry1[fullUrlAryLen2-1];
						//System.out.println(fullImageName3);
						
						//String[] values = {"Coupon_LP_Graphic_1200x1200.jpg","Coupon_Roomscene_2000x2000.jpg","/Homepage_Graphic_1200x1200.jpg","desktop_304_fullwidthbanner1440x100.jpg","background_301_homepageroomscene1600x500.jpg"};
						// creating an Empty String ArrayList 
				        ArrayList<String> arr = new ArrayList<String>(4);
				        arr.add("graphic_90_ssheaderblock1200x1200.jpg"); 
				        arr.add("background_90_sshomepageheaderroomscene1600x500.jpg"); 
				        arr.add("Coupon_Roomscene_2000x2000.jpg");
				        boolean ans = arr.contains(fullImageName3); 
				    
						if(ans) {
							System.out.println("Url contains old image "+ImageUrl );
							//break;
							
						}else {
							//System.out.println("");
							//break;
						}
		    		  }
		    	  }
		      
		      }else {
					 
		    	  System.out.println("Url is not from same domain");
				 }
		 }
		 
		    
		 }
		 
		 System.out.println("-----------------------------------------------------------");
		 Thread.sleep(3000);
		 
		 }
		}catch(Exception e) {
			
			System.out.println("Exception"+ e);
			
			
		}
	
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}


}
