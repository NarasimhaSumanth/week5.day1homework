package week5.day1homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends Servicenow{

	@Test
	public void deleteIncident() throws InterruptedException {

		
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();				
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys("INC0010017");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.linkText("INC0010017")).click();
		driver.findElement(By.id("sysverb_delete")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Delete this record?']/following-sibling::div/button[@id='ok_button']")).click();
		Thread.sleep(3000);
		WebElement search1 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search1.sendKeys("INC0010017");
		WebElement result = driver.findElement(By.xpath("//tbody[@class='list2_body']//td"));
		String resultText = result.getText();
		
		if (resultText.equals("No records to display")) {
			
			System.out.println("Incident not found & deleted");
			
		} else {
			System.out.println("Fail");

		}
		

	}

}
