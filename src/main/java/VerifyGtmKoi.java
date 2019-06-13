import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyGtmKoi {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		driver = new HtmlUnitDriver();
		driver.manage().deleteAllCookies();
		
		
		
	}
	
	@Test
	public void verifyGTMKOI() {
		
		try {
			
			File fp=new File("./TestData/GTM.xlsx");
			FileInputStream fis= new FileInputStream(fp);
			XSSFWorkbook book= new XSSFWorkbook(fis);
			XSSFSheet sh= book.getSheetAt(0);
			
			System.out.println("GTM & KOI verification Starts");
			for(int i=0;i<sh.getLastRowNum();i++) {
				
				for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
					
					String urlview = sh.getRow(i+1).getCell(0).getStringCellValue();
					
					driver.get(urlview);
				
				
					Boolean gtm=driver.getPageSource().contains("(window,document,'script','dataLayer', 'GTM-");
					Boolean igtm=driver.getPageSource().contains("//www.googletagmanager.com/ns.html?id=GTM-");
					Boolean koi=driver.getPageSource().contains("KOI-");
					if(gtm){
						
					//	System.out.println("GTM 1st present on Url  "+urlview+" Pass");
					   
					}else {
						System.out.println("GTM 1st not present on Url  "+urlview+" Fail");
						
					}
					
					
					if(igtm) {

						//System.out.println("GTM 2nd present on Url  "+urlview+" Pass");
						
					}else {
						System.out.println("GTM 2nd not present on Url  "+urlview+" Fail");;
					}
					
	
					
					if(koi) {
						
						//System.out.println("KOI is present on Url"+urlview);
						
						
						
					}else {
						
						System.out.println("KOI is not present "+urlview+"Fail");
						
						
					}
					
	
					
				}
				
			}
			
			System.out.println("GTM & KOI verification Ends");
			
				
		}catch(Exception e) {
			
			System.out.println("Exception Found :"+e);
			e.printStackTrace();
			
		}
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
		
	}

}
