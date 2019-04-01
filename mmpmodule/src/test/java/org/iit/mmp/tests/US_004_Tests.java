package org.iit.mmp.tests;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.iit.mmp.pages.RegistrationPage;
import org.iit.mmp.util.BaseClass;
import org.testng.annotations.Test;

public class US_004_Tests extends BaseClass {
	HashMap<String, String> hMapPatientData;
	@Test
	public void registerPatientTests() throws Exception
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		Random rdm = new Random();
		String username = "Test" + rdm.nextInt(999999);
		String password = "Test1234";
		String email = username + "@gmail.com";
		String answer = "Shepherd";

		RegistrationPage regPage = new RegistrationPage(driver);
		hMapPatientData = regPage.register(email, username, password, answer);
		Set<String> setFieldKeys = hMapPatientData.keySet();

		for (String setFieldKey : setFieldKeys) {
			System.out.println("Key : " + setFieldKey + "     Value: " + hMapPatientData.get(setFieldKey));
		}
		
	}

}
