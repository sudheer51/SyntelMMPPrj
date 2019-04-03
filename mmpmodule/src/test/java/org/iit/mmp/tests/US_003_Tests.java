package org.iit.mmp.tests;

import java.util.List;

import org.iit.mmp.util.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_003_Tests extends BaseClass{
	 
	@Parameters({"adminurl"})
	@Test
	public void addPrescription(String adminurl)
	{
		driver.get(adminurl);
		boolean result = searchByName("ria");
		Assert.assertTrue(result);
		
	}
	public boolean searchByName(String name)
	{
		boolean result = false;
		driver.findElement(By.id("search")).clear();
		driver.findElement(By.id("search")).sendKeys("ria");
		driver.findElement(By.className("tfbutton")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='show']/table//tr//a")));
		
		List<WebElement> trList = driver.findElements(By.xpath("//div[@id='show']/table//tr//a"));
		for(int i=0;i<trList.size();i++)
		{
			if(trList.get(i).getText().equals(name))
			{
				trList.get(i).click();
				System.out.println("Clicked on "+name);
				result = true;
				break;
			}
		}
		return result;
	}
	

}
