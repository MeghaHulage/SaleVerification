package TestScenarios;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHtmlunit {
	
	WebDriver driver;
	List<String> addallaTagUrl = new ArrayList<String>();
	ArrayList<String> arr = new ArrayList<String>();
	List<String> newList = new ArrayList<String>();



		
		@BeforeTest
		public void setUp() {
			arr.add("graphic_90_ssheaderblock1200x1200.jpg"); 
			arr.add("background_90_sshomepageheaderroomscene1600x500.jpg"); 
			arr.add("graphic_91_ssjabaraspopup850x315.jpg");
			arr.add("desktop_92_iqfloors1090x274.jpg");
			arr.add("mobile_93_ssfullwidthbannermobile320x684.jpg");
			arr.add("desktop_98_ssbanner728x90.jpg");
			arr.add("graphic_101_ssnavigationgraphic978x90.jpg");
			arr.add("background_102_ssroomscene2000x2000.jpg");
			arr.add("graphic_102_sslong814x314.jpg");
			arr.add("mobile_102_sssquaremobile1200x1200.jpg");
			arr.add("graphic_103_sssquaremobile1200x1200.jpg");
			arr.add("background_103_ssroomscene2000x2000.jpg");
			arr.add("mobile_103_sssquaremobile1200x1200.jpg");
			arr.add("graphic_104_verticalcouponimage484x772.jpg");
			arr.add("background_104_ssroomscene2000x2000.jpg");
			arr.add("mobile_104_sssquaremobile1200x1200.jpg");
			
			//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
			//WebDriver driver = new HtmlUnitDriver();
			
			//driver.manage().deleteAllCookies();
			//driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//driver.get("https://hamernicks.com/site-map/");
			
			
			
		}
		
		@Test()
		public void verifyImage() throws Exception {
			WebDriver driver = new HtmlUnitDriver();
			driver.manage().deleteAllCookies();
			
			driver.get("https://colorinteriors.com/site-map/");
			
			
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			
			 for (int k=1; k<links.size();k++)
				 
			 {
				 String tagaurl=links.get(k).getAttribute("href");
				
				// System.out.println(tagaurl);
				// System.out.println("****************************************");
				
				 addallaTagUrl.add(tagaurl);
				 
				 //Set<String> hs1 = new LinkedHashSet<String>(addallaTagUrl);
			       // List<String> newList = new ArrayList<>(hs1);
				 
			       for(String name :  addallaTagUrl){
			           if(!newList.contains(name)){
			               newList.add(name);
			           }
			        }
				 
				
			 }
			 
			 System.out.println("Start");
			 
			 for(int i=0;i<newList.size();i++) {
				 
				 //System.out.println("Url to launch"+addallaTagUrl.get(i));
				 //Thread.sleep(1000);
				 if( newList.get(i).startsWith("https://")) {
				 driver.get(newList.get(i));
				
				 
				 System.out.println("Url Launched : "+newList.get(i));
				 //System.out.println("-----------------------------------------");
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
					Thread.sleep(100);
					List<WebElement> allImages = driver.findElements(By.tagName("img"));
					 for(int n=0;n<allImages.size();n++){
						 
						 String ImageUrl=allImages.get(n).getAttribute("src");
					     
					      if( ImageUrl.startsWith("https://")) {
						    	 
					    	  if(ImageUrl.endsWith(".jpg")) {
					    		  
					    		  if(!ImageUrl.endsWith("logo.jpg")) {
					    			
					    		  //System.out.println(ImageUrl);
					    		  
					    		  String[] fullUrlAry1 = ImageUrl.split("/");
									
									Integer fullUrlAryLen2 = fullUrlAry1.length;
									
									String fullImageName3 = fullUrlAry1[fullUrlAryLen2-1];
																
							        boolean ans = arr.contains(fullImageName3); 
							    
									if(ans) {
										//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
										System.out.println("Url "+ newList.get(i)+"contains Coupon image "+ImageUrl );
										break;
										
									}else {
										//System.out.println("");
										//break;
									}
					    		  }
					    	  }
					      }
					 }
					 
				 }
					// System.out.println("------------------------------------------");
				 
			 }
							
			 System.out.println("End");
			
			
		}
		
		@AfterTest
		public void tearDown() {
			
			driver.close();
		}


		

}
