package TestScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckOldCoupn {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe" );
		
		
		
	}
	
	@Test
	public void couponVerification() throws IOException, InterruptedException {
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.get("https://fleurysfloorcovering.com");
		//try {
		//File fp=new  File("C:\\CT.xlsx");
		
		
		//FileInputStream fis=new FileInputStream(fp);
		//XSSFWorkbook book=new XSSFWorkbook(fis);
		//XSSFSheet sh= book.getSheetAt(0);
		
		//for(int i=0;i<sh.getLastRowNum();i++) {
			
		//	for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
				
			//String retailerurl=sh.getRow(i+1).getCell(0).getStringCellValue();
		try {
			driver.get("https://fleurysfloorcovering.com/");
				//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
				 
				 System.out.println(links.size());
				 
				 for (int k = 1; k<=links.size(); k=k+1)
				 
				 {
				 
				 System.out.println(links.get(k).getAttribute("href"));
				 System.out.println("-----------------------------------------------------------");
				 List<WebElement> allImages = driver.findElements(By.tagName("img"));
				 for(int n=0;n<=allImages.size();n++){
				      String ImageUrl=allImages.get(n).getAttribute("src");
				     System.out.println(ImageUrl); //will get you all the image urls on the page
				     
				     //check ImageUrl starts with https://
				      
				     if( ImageUrl.startsWith("https://")) {
				    	 
				    	  if(ImageUrl.endsWith(".jpg")) {
						//String cImage = allImages.get(n).getAttribute("src");
						
						String[] fullUrlAry1 = ImageUrl.split("/");
						
						Integer fullUrlAryLen2 = fullUrlAry1.length;
						
						String fullImageName3 = fullUrlAry1[fullUrlAryLen2-1];
						System.out.println(fullImageName3);
						
						String[] values = {"graphic_301_homepagegraphic1200x1200.jpg","desktop_304_fullwidthbanner1440x100.jpg","background_301_homepageroomscene1600x500.jpg"};
						boolean contains = Arrays.asList(values).contains(fullImageName3);
						if(contains) {
							System.out.println("Url contains old image"+ImageUrl );
							break;
							
						}else {
							System.out.println("Url not contains old images"+ImageUrl );
							break;
						}
						
				    	  }
				    	  
				    	  
				     }else {
				      
				    	 System.out.println("Url is not http");
				    	
				    	 break;
				      
				 }
				 
				 
				 
				 
				 }
						
						 
				
						
					}
				
		//	}
			
			
		//}
		}catch(Exception e) {
			
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}
	
	

}
