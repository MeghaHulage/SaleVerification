package TestScenarios;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSaleForJun {
	WebDriver driver;
	List<String> addallaTagUrl = new ArrayList<String>();
	ArrayList<String> arr = new ArrayList<String>();
	List<String> newList = new ArrayList<String>();
	

		
		@BeforeTest
		public void setUp() {
			
			arr.add("graphic_301_homepagegraphic1200x1200.jpg"); 
	        arr.add("graphic_302_jabarashomepagepopup850x315.jpg");
	    	arr.add("background_301_homepageroomscene1600x500.jpg");
	    	
	    	arr.add("graphic_301_homepagegraphic1200x1200.jpg"); 
	    	arr.add("graphic_302_jabarashomepagepopup850x315.jpg");
    	    arr.add("desktop_303_iqfloorshomepage1090x274.jpg");
	    	arr.add("mobile_304_ssfullwidthbannermobile320684.jpg");
	    	arr.add("desktop_309_categorypagebanner728x90.jpg");
	    	arr.add("graphic_312_navigationgraphic978x90.jpg");
	    	arr.add("graphic_313_couponlpgraphic814x314.jpg");
	    	arr.add("graphic_314_couponlpgraphic1200x1200.jpg");
	    	arr.add("graphic_315_springsalepayless.jpg");
	    	arr.add("background_313_couponroomscene2000x2000.jpg");
	    	arr.add("background_314_couponroomscene2000x2000.jpg");    
	    	arr.add("background_315_couponroomscene2000x2000.jpg");
	    	
	    	
			
			//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
			//WebDriver driver = new HtmlUnitDriver();
			
			//driver.manage().deleteAllCookies();
			//driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//driver.get("https://hamernicks.com/site-map/");
	    	java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
	    	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
			
		}
		
		@Test()
		public void verifyImage() throws Exception {
			
			WebDriver driver = new HtmlUnitDriver();
			driver.manage().deleteAllCookies();
			
			driver.get("https://pdjflooring.com/site-map/");
			
			
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
			 try {
			 
			 for(int i=0;i<newList.size();i++) {
				 
				 //System.out.println("Url to launch"+addallaTagUrl.get(i));
				 System.out.println("Url to launch"+newList.get(i));
				 //Thread.sleep(1000);
				 if( newList.get(i).startsWith("https://")) {
				 driver.get(newList.get(i));
				
				 
				// System.out.println("Url Launched : "+newList.get(i));
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
			 }catch(Exception e) {
				 
				 System.out.println("Exception"+e);
				 e.printStackTrace();
				
				 
			 }
			
			
		}
		
		@AfterTest
		public void tearDown() {
		//driver.close();	
		}


		

}
