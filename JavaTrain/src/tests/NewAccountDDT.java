package tests;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	/*String name;
	String email;
	String phone;
	String gender;
	String password;
	String country;
	boolean weeklyEmail;
	boolean monthlyEmail;
	boolean occasionalEmail;
	WebDriver driver;*/
	String name,email,phone,gender,password,country;
	boolean weeklyEmail,monthlyEmail,occasionalEmail;
	WebElement nameElement,emailElement,phoneElement,passwordElement,verifyPasswordElement,countryElement,femaleRadio,maleRadio,weeklyCheckbox;
	WebDriver driver;
	
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		/*if (phone.equals("7894561230")) {
			Assert.fail();
		}*/
		
		/*driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();*/
		
		/*WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement femaleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));*/
		
		defineWebElements();
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone); 
		passwordElement.sendKeys(password);
		//driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/div[3]/div[2]/input")).sendKeys("1231231234");
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		if (gender.equalsIgnoreCase("Female")) {femaleRadio.click();}
		else {maleRadio.click();}
		
		if (weeklyEmail){
			if (!weeklyCheckbox.isSelected()){weeklyCheckbox.click();}}
		else {
			if(weeklyCheckbox.isSelected());{weeklyCheckbox.click();}
		}
		
		//driver.findElement(By.id("MainContent_btnSubmit")).click();
	}
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public void defineWebElements() {
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		femaleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		maleRadio = driver.findElement(By.id("MainContent_Male"));
		weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		
	}
	@Parameters
	public static List<String[]> getData(){
		return utilities.CSV.get("C:\\Users\\vnikolic\\Desktop\\Selenium\\UserAccounts.csv");
	} 
	
	//Constructor
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, 
			String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		
		if (weeklyEmail.equals("TRUE")) {this.weeklyEmail = true;}
		else {this.weeklyEmail = false;}
		
		if (monthlyEmail.equals("TRUE")) {this.monthlyEmail = true;}
		else {this.monthlyEmail = false;}
		
		if (occasionalEmail.equals("TRUE")) {this.occasionalEmail = true;}
		else {this.occasionalEmail = false;}
	}

}
