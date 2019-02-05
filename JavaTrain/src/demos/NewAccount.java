package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Vlaca Pro";
		String email = "vp@testmail.com";
		String password = "mspass";
		String phoneNumber = "1231231234";
		String country = "Germany";
		String browserType = "firefox";
		
		String gender = "Male";
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occassionalEmail = false;
		
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
			
		/*if(browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}*/
			
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/div[2]/a")).click();
		
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtVerifyPassword']"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement femaleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement weeklyCheckbox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber); 
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
		
		
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successsfully";
		if (conf.equals(expected)) {System.out.println("CONFIRMATION: " + conf);}
		else {System.out.println("TEST FAILED");}
		
		
		driver.close();
	}

}
