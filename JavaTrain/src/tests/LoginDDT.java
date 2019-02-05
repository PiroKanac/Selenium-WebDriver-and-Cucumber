package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");*/
		
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);

		//driver.close();
		
	}
	
	@BeforeMethod
	public void setUp() {
		/*driver = new ChromeDriver();*/
		driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() {
		return utilities.Excel.get("C:\\Users\\vnikolic\\Desktop\\Selenium\\UserLogin.xls");
	}

}
