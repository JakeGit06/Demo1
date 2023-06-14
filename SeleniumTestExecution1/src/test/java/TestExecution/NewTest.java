package TestExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void Test1() {
	  	System.setProperty("webdriver.chrome.driver","D:\\Browser Drivers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("single-input-field")).sendKeys("Hello");
		driver.findElement(By.xpath("//button[@id='button-one']")).click();
  }
}
