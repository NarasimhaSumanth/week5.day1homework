package week5.day1homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends Servicenow {
	@Test
	
	public void assignIncident() throws InterruptedException {
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys("INC0008111");
		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[text()='INC0008111']")).click();
		
		WebElement assignGroup = driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span"));
		assignGroup.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		String child = window.get(1);
		driver.switchTo().window(child);
		
		System.out.println(driver.getTitle());
		
		WebElement search1 = driver.findElement(By.xpath("//span[text()='Press Enter from within the input to submit the search.']/following-sibling::input"));
		search1.sendKeys("Software");
		search1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(window.get(0));
		
		driver.switchTo().frame("gsft_main");
		WebElement desc = driver.findElement(By.id("incident.description"));
		desc.clear();
		desc.sendKeys("Test software group");
		driver.findElement(By.id("sysverb_update")).click();
		System.out.println("update action done");
		driver.findElement(By.xpath("//a[text()='INC0008111']")).click();
		
		WebElement group = driver.findElement(By.id("sys_display.incident.assignment_group"));
		String attribute = group.getAttribute("value");
		System.out.println("Assigned to "+ attribute);
		String text2 = driver.findElement(By.id("incident.description")).getText();
		System.out.println("Work notes "+ "is "+ text2);
		
		
		
		

	}
}
