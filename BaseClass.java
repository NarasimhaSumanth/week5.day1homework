package week5.day1homework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.Excel;

public class BaseClass {
	
	public ChromeDriver driver;
	public String fileName;
	@Parameters({"url","userName","passWord"})
	@BeforeMethod
	  public void beforeMethod(String url, String uName, String pWord ) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pWord);
		driver.findElement(By.className("decorativeSubmit")).click();
	  }

	  @AfterMethod
	  public void afterMethod() {
		 driver.close();
		  
	  }
	  
	  @DataProvider()
		public String[][] sendData() throws IOException {

			/*String[][] data = new String[2][3];

			data[0][0] = "Legato";
			data[0][1] = "Sumanth";
			data[0][2] = "k";

			data[1][0] = "Legato1";
			data[1][1] = "sumanth1";
			data[1][2] = "k";*/
			return Excel.readData(fileName);
		}

}
