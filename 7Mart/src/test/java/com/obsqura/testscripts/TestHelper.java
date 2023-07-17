package com.obsqura.testscripts;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.obsqura.utilities.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHelper {
	WebDriver driver;

	@BeforeMethod
	@Parameters("chromebrowser")
	public void browserLaunching(@Optional("chrome") String browser) {
		FileReaderUtility fr = new FileReaderUtility();
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", fr.getChromeDriverPath());
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", fr.getEdgeDriverPath());
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("hello");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.navigate().to(fr.getApplicationUrl());
		driver.manage().window().maximize();
	}

//@Test
	public void test() {

	}

	@AfterMethod
	public void browserClosing(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				
			TakesScreenshot screenshot=(TakesScreenshot)driver;
				
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir");
			FileUtils.copyFile(src,new File(path+"\\target"+result.getName()+".png"));
			
			   System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			}
           }


		driver.quit();
	}
}
