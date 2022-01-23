package week5.day1homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends Servicenow {
@Test
	public void updateIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();				
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");
		WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		search.sendKeys("INC0008111");
		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[text()='INC0008111']")).click();
		WebElement dd1 = driver.findElement(By.name("incident.urgency"));
		
		Select urgency = new Select(dd1);
		urgency.selectByVisibleText("1 - High");
		
		WebElement dd2 = driver.findElement(By.name("incident.state"));
		
		Select state = new Select(dd2);
		state.selectByVisibleText("In Progress");
		
		driver.findElement(By.id("sysverb_update")).click();
		driver.findElement(By.xpath("//a[text()='INC0008111']")).click();
		
		WebElement dd5 = driver.findElement(By.name("incident.urgency"));		
		Select urgency1 = new Select(dd5);
		WebElement dd3 = urgency1.getFirstSelectedOption();		
		System.out.println("Urgency selected " + "is "+dd3.getText());
		
WebElement dd6 = driver.findElement(By.name("incident.state"));
		
		Select state1 = new Select(dd6);
		WebElement dd4 = state1.getFirstSelectedOption();
		System.out.println("State selected "+"is "+ dd4.getText());
		
		
		

	}

}
