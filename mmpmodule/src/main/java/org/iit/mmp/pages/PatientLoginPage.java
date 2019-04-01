package org.iit.mmp.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PatientLoginPage {
	WebDriver driver;
	By usernameID = By.id("username");
	By passwordID = By.id("password");
	By submitName = By.id("submit");
	By tagNameText = By.tagName("h3");
	By forgotHLink = By.linkText("forgot Username / Password");
	public PatientLoginPage(WebDriver driver ) {
		this.driver=driver;
	}
	public boolean login(String username,String password)
	{
		driver.findElement(usernameID).sendKeys(username);
		driver.findElement(passwordID).sendKeys(password);
		driver.findElement(submitName).click();
		return driver.findElement(tagNameText).getText().contains(username);
	}
	public boolean clickForgotUsername()
	{
		driver.findElement(By.linkText(""));
		return true;
	}

}
