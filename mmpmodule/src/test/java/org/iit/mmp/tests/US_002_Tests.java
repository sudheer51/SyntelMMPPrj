package org.iit.mmp.tests;

import java.util.List;

import org.iit.mmp.pages.PatientLoginPage;
import org.iit.mmp.util.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class US_002_Tests extends BaseClass {
	@Parameters({"username","password","url"})
	@Test(priority=1)
	public void loginPatient(String username,String password,String url)
	{
		    driver.get(url);
		    PatientLoginPage p1 = new PatientLoginPage(driver);			
		    boolean result = p1.login(username,password);
			Assert.assertTrue(result,"Login is unsuccesful");
	}

	@Test(priority=2,enabled=false,description="Validation for Patient Data")
	public void patientAppointmentHeaderValue()
	{
			List<WebElement> hList = validatePatientHeaderValues();
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(hList.get(0).getText().contains("Date"),"Date is not displayed in Header");
			sa.assertTrue(hList.get(1).getText().contains("Times"),"Time is not displayed in Header");
			sa.assertTrue(hList.get(2).getText().contains("Appointment"),"Appointment is not displayed in Header");
			sa.assertTrue(hList.get(3).getText().contains("Doctor"),"Doctor is not displayed in Header");
			sa.assertAll();
			 
			
			
	}
	public List<WebElement> validatePatientHeaderValues()
	{
		List<WebElement> thValues = driver.findElements(By.xpath("//table[@class='table']//th"));
		return thValues;
	}
	 

}
