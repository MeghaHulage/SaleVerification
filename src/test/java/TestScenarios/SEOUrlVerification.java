package TestScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SEOUrlVerification {
	
	WebDriver driver;
	//List<String> allurls= new ArrayList<String>();
	//List<String> sortedurls = new ArrayList<String>();
	List<String> addallaTagUrl = new ArrayList<String>();
	List<String> newList = new ArrayList<String>();
	
	String locationName= "Denver, NC";
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
			
	}
	
	@Test
	public void verifySEO() {
		
	
		try {
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			driver.get("https://westportflooringandinteriors.com/");
			
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			
			 for (int k=1; k<links.size();k++)
				 
			 {
				 String tagaurl=links.get(k).getAttribute("href");
				
				
				
				 addallaTagUrl.add(tagaurl);
				 
				 
				 
			        for(String name :  addallaTagUrl){
			            if(!newList.contains(name)){
			                newList.add(name);
			            }
			        }
				 
				
			 }
			 
			
			 
			 for(int i=0;i<newList.size();i++) {
				 
				
				 
				 if(newList.get(i).startsWith("https://westportflooringandinteriors.com/")) {
				 driver.get(newList.get(i));
				// Thread.sleep(2000);
				System.out.println("Url Launched : "+newList.get(i));
				//String title = driver.getTitle();
			
				 Boolean SEOcheck=driver.getTitle().contains(locationName);
			
				 
				 if(SEOcheck){
					 
					 System.out.println("shows window title :"+ driver.getTitle());
						System.out.println("SEO Pass on URL  " );
						 System.out.println("_____________________________________________________");
						
					
					   
					}else {
						
						
					
						System.out.println("shows window title :"+ driver.getTitle());
						System.out.println("SEO Fail on URL  ");
						 System.out.println("_____________________________________________________");
						
					}
				 }
				 }
			// }
		}catch(Exception e) {
			 e.printStackTrace();
			 
		 }
		
		
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
	}

}
