package TestScenarios;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class VerifyLinksHttps {
	
	WebDriver driver;
	
	 @Test
	  public void verifyLinks() {
		  
	  
		  
		  java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			
			//String href;
			
			for(int i=0;i<=links.size();i++) {
				
				WebElement ele=links.get(i);
				
				String linkurl= ele.getAttribute("href");
				
		  
		  try{
			  
			  URL url=new URL(linkurl);
			  HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

			  httpURLConnect.setConnectTimeout(3000);
			  httpURLConnect.connect();
			  if(httpURLConnect.getResponseCode()==200){

			  System.out.println(linkurl+"-"+httpURLConnect.getResponseMessage());

			  }
			  if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
			  System.out.println(linkurl +"-"+httpURLConnect.getResponseMessage());
			  }
			  }catch(Exception e){
			  System.out.println("Exception:"+e);
			  }
		  
	  }
			
		  
		  
	  }
	  @BeforeTest
	  public void openlink() {
		  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
			
			driver.get("https://shoproyalflooring.com/");
	  }
	  

	  @AfterTest
	  public void afterTest() {
driver.close();
	  }


}
