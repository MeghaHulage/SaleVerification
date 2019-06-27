package TestScenarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe" );
		try {
			   String cmd = "C://gtr2019//gtr.bat";
			   Runtime r = Runtime.getRuntime();
			   Process pr = r.exec(cmd);
			   BufferedReader stdInput = new BufferedReader(
			       new InputStreamReader( pr.getInputStream() ));
			   String s ;
			   while ((s = stdInput.readLine()) != null) {
			       System.out.println(s);
			   }
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
	}


