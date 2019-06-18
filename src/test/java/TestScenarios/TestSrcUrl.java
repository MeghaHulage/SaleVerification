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

public class TestSrcUrl {
	
	WebDriver driver;
	List<String> addallaTagUrl = new ArrayList<String>();
	List<String> newList = new ArrayList<String>();
		@BeforeTest
		public void setUp() {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			//driver.get("https://colorinteriors.com/");
	    
			
		}
		
		@Test(priority=0)
		public void verifyGTM() throws InterruptedException {
			
			try {
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			driver.get("https://floorsbyroberts-stg.mm-dev.agency");
			
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			
			 for (int k=1; k<links.size();k++)
				 
			 {
				 String tagaurl=links.get(k).getAttribute("href");
				
				// System.out.println(tagaurl);
				// System.out.println("****************************************");
				
				 addallaTagUrl.add(tagaurl);
				 
				 
				 
			        for(String name :  addallaTagUrl){
			            if(!newList.contains(name)){
			                newList.add(name);
			            }
			        }
				 
				
			 }
			 
			
			 
			 for(int i=0;i<newList.size();i++) {
				 
				 //System.out.println("Url to launch"+addallaTagUrl.get(i));
				 //Thread.sleep(1000);
				// if(!newList.get(i).startsWith("tel:")) {
				 
				 if(newList.get(i).startsWith("https://")) {
				 driver.get(newList.get(i));
				// Thread.sleep(2000);
				System.out.println("Url Launched : "+newList.get(i));
				
				java.util.List<WebElement> srclinks = driver.findElements(By.tagName("img"));
				
				for(int j=0;j<srclinks.size();j++) {
					
					String srcurl= srclinks.get(j).getAttribute("src");
					
					if(srcurl.startsWith("https://floorsbyroberts-stg.mm-dev.agency/") ||srcurl.startsWith("https://mobilem.liquifire.com")) {
						//https://mobilem.liquifire.com
						
						
						//System.out.println("Src image starts with domain :"+srcurl);
						
						
					}else {
						
						System.out.println("Src image not starts with domain :"+srcurl);
					}
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
			
			driver.close();
		}
		


}
