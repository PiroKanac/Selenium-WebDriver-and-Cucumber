package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vnikolic\\Downloads\\Selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	
	driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("tim@testemail.com");
	
	driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("trpass");
	
	driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	
	String message = driver.findElement(By.id("conf_message")).getText();
	System.out.println("CONFIRMATION: " + message);
	
	String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE:" + pageTitle);
	
	driver.close();
	}
}
