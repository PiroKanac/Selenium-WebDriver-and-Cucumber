package tests;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "Chrome";
	String city = "New York, NY";
	String checkIn = "10/19/2018";
	//String checkOut = "11/14/2018";
	
	
	@Test
	public void hotelReservation() {
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		//driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
		//driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).click();
		//driver.findElement(By.xpath("//*[@id=\"hotel-checkin-wrapper-hp-hotel\"]/div/div/div[1]/button/span")).click();
		//driver.findElement(By.className("btn-primary btn-action  gcw-submit")).click();
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		
		// 2. Modify the search  results page, give criteria
		//driver.findElement(By.className("uitk-button-container")).click();
		
		driver.findElement(By.cssSelector("input[name = 'star'][id = 'star4']")).click();	
		
		// Switch the window to the pop
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
