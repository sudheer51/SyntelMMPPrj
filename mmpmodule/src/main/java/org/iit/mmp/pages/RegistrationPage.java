package org.iit.mmp.pages;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	WebDriver driver;
	HashMap<String, String> hMap = new HashMap<String, String>();

	By patientLogin = By.linkText("Patient Login");
	By register = By.xpath("//input[@value='Register']");
	By firstName = By.id("firstname");
	By lastName = By.id("lastname");
	By dateOfBirth = By.id("datepicker");
	By license = By.id("license");
	By ssn = By.id("ssn");
	By state = By.id("state");
	By city = By.id("city");
	By address = By.id("address");
	By zipCode = By.id("zipcode");
	By age = By.id("age");
	By height = By.id("height");
	By weight = By.id("weight");
	By pharmacy = By.id("pharmacy");
	By pharmacyAddress = By.id("pharma_adress");
	By email = By.id("email");
	By password = By.id("password");
	By username = By.id("username");
	By confirmPassword = By.id("confirmpassword");
	By selectSecurityQuestion = By.xpath("//*[@id='security']");
	By answer = By.id("answer");
	By saveButton = By.name("register");

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
	}

	public void clickPatientLogin() {

		driver.findElement(patientLogin).click();

	}

	public void clickRegister() {

		driver.findElement(register).click();
	}

	public void enterFirstName() {
		driver.findElement(firstName).clear();
		String fNameValue = "testFN" + getRandomChar();
		driver.findElement(firstName).sendKeys(fNameValue);
		hMap.put("firstName", fNameValue);

	}

	public void enterLastName() {
		driver.findElement(lastName).clear();
		String lNameValue = "testLN" + getRandomChar();
		driver.findElement(lastName).sendKeys(lNameValue);
		hMap.put("lastName", lNameValue);

	}

	public void enterDateOfBirth() {
		WebElement datePicker = driver.findElement(dateOfBirth);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		datePicker.sendKeys(sdf.format(new Date()));
		hMap.put("date", datePicker.getAttribute("value"));
	}

	public void enterLicense() {
		driver.findElement(license).clear();
		String licenseValue = Integer.toString(getRandomNumber(10000000, 7));
		System.out.println("Entering License Value::" + licenseValue);
		driver.findElement(license).sendKeys(licenseValue);
		hMap.put("license", licenseValue);

	}

	public void enterSSN() {
		driver.findElement(ssn).clear();
		String ssnValue = Integer.toString(getRandomNumber(100000000, 8))+getRandomChar();
		System.out.println("Entering SSN Value::" + ssnValue);
		driver.findElement(ssn).sendKeys(ssnValue);
		hMap.put("ssn", ssnValue);

	}

	public void enterState() {

		WebElement stateTxt = driver.findElement(state);
		stateTxt.sendKeys("New York");
		hMap.put("state", stateTxt.getAttribute("value"));
	}

	public void enterCity() {
		WebElement cityTxt = driver.findElement(city);
		cityTxt.sendKeys("seattle");
		hMap.put("city", cityTxt.getAttribute("value"));

	}

	public void enterAddress() {
		WebElement addressTxt = driver.findElement(address);
		addressTxt.clear();
		addressTxt.sendKeys("9 street");
		hMap.put("address", addressTxt.getAttribute("value"));
	}

	public void enterZipCode() {

		WebElement zipcodeTxt = driver.findElement(zipCode);
		zipcodeTxt.sendKeys(Integer.toString(getRandomNumber(10000, 4)));
		hMap.put("zipcode", zipcodeTxt.getAttribute("value"));

	}

	public void enterAge() {

		WebElement ageTxt = driver.findElement(age);
		ageTxt.sendKeys(Integer.toString(getRandomNumber(30, 1)));
		hMap.put("age", ageTxt.getAttribute("value"));
	}

	public void enterHeight() {
		WebElement heightTxt = driver.findElement(By.id("height"));
		heightTxt.sendKeys("200");
		hMap.put("height", heightTxt.getAttribute("value"));
	}

	public void enterWeight() {
		WebElement weightTxt = driver.findElement(weight);
		weightTxt.sendKeys("60");
		hMap.put("weight", weightTxt.getAttribute("value"));
	}

	public void enterPharmacy() {
		driver.findElement(pharmacy).clear();
		driver.findElement(pharmacy).sendKeys("MMP Pharmacy");
	}

	public void enterpharmacyAddress() {
		driver.findElement(pharmacyAddress).clear();
		driver.findElement(pharmacyAddress).sendKeys("12 Chipmunk Crossing");
	}

	public void enterEmail(String emailValue) {
		WebElement emailTxt = driver.findElement(email);
		emailTxt.clear();
		emailTxt.sendKeys(emailValue);
		hMap.put("email", emailTxt.getAttribute("value"));
	}

	public void enterPassword(String pword) {
		WebElement pwordTxtbox = driver.findElement(password);
		pwordTxtbox.clear();
		pwordTxtbox.sendKeys(pword);
		hMap.put("password", pwordTxtbox.getAttribute("value"));
	}

	public void enterUsername(String uname) {
		WebElement userNameTxtbox = driver.findElement(username);
		userNameTxtbox.clear();
		userNameTxtbox.sendKeys(uname);
		hMap.put("username", userNameTxtbox.getAttribute("value"));
	}

	public void enterConfirmPassword(String strCPassword) {
		WebElement cPassword = driver.findElement(confirmPassword);
		cPassword.clear();
		cPassword.sendKeys(strCPassword);
		hMap.put("cPassword", cPassword.getAttribute("value"));
	}

	public void SelectSecurityQuestion() throws InterruptedException {

		new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your pet name");
	}

	public void enterAnswer(String strSQAnswer) {

		WebElement answerTxt = driver.findElement(answer);
		answerTxt.sendKeys(strSQAnswer);
		hMap.put("answer", answerTxt.getAttribute("value"));
	}

	public void clickSaveButton() {

		driver.findElement(saveButton).click();
	}

	public void alertBox() {

		Alert alert = driver.switchTo().alert();

		alert.accept();
	}

	public char getRandomChar() {
		Random rnd = new Random();
		int k = 97 + rnd.nextInt(26);
		System.out.println((char) k);
		return (char) k;
	}

	public int getRandomNumber(int limit, int digits) {
		Random rnd = new Random();
		String value = "";
		for (int i = 0; i < digits; i++) {
			value = value + "9";
		}
		int result = Integer.parseInt(value) + rnd.nextInt(limit);
		return result;
	}

	public HashMap<String, String> register(String emailID, String userName, String password, String answer)
			throws Exception {

	//	clickRegister();
		enterFirstName();
		enterLastName();
		enterDateOfBirth();
		enterSSN();
		enterLicense();
		enterState();
		enterCity();
		enterAddress();
		enterZipCode();
		enterAge();
		enterHeight();
		enterWeight();
		enterPharmacy();
		enterpharmacyAddress();
		enterEmail(emailID);
		enterPassword(password);
		enterUsername(userName);
		enterConfirmPassword(password);
		SelectSecurityQuestion();
		enterAnswer(answer);

		clickSaveButton();

		try {
			alertBox();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hMap;
	}

}