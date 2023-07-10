package com.obsqura.testscripts;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.obsqura.utilities.*;
public class TestHelper{
	WebDriver driver;

	@BeforeMethod
	@Parameters("chromebrowser")
	public void browserLaunching(String browser) {
		FileReaderUtility fr = new FileReaderUtility();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", fr.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", fr.getEdgeDriverPath());
			driver = new EdgeDriver();
		}
		driver.navigate().to(fr.getApplicationUrl());
		driver.manage().window().maximize();
	}

//@Test
	public void test() {

	}

//@AfterMethod
	public void browserClosing(ITestResult result)throws IOException{
		/*if(ITestResult.FAILURE==result.getStatus()){
			try{
				
				TakesScreenshot screenshot=(TakesScreenshot)driver;
					
				File src=screenshot.getScreenshotAs(OutputType.FILE);
			
				FileUtils.copyFile(src,new File("C:\\screenshots"+result.getName()+".png"));
				
				   System.out.println("Successfully captured a screenshot");
				}

		}*/
		driver.quit();
	}
}

