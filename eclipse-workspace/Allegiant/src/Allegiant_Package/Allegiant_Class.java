package Allegiant_Package;

import java.util.concurrent.TimeUnit;
import java.util.Set;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Allegiant_Class {
	public static void main(String[] args) {

		//setting the driver executable
		System.setProperty("webdriver.gecko.driver", "/home/lauramt/Documents/Allegiant/geckodriver");

		//Initiating the Firefox Driver
		WebDriver driver=new FirefoxDriver();


		//open allegiantair.com
		driver.get("https://www.allegiantair.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//*[@id=\"credit-card-overlay\"]/div/div/div[1]/a/img")).click();
	    String base = driver.getWindowHandle();

	    Set <String> set = driver.getWindowHandles();

	    set.remove(base);
	    assert set.size()==1;

	    for(String winHandle : driver.getWindowHandles()){
	            driver.switchTo().window(winHandle);
	    }
	    
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().window(base);		
		
		
		
		WebElement departCity = driver.findElement(By.name("search_form[departure_city]"));
		departCity.click();
		String city = "Anchorage, AK (ANC)";
		WebElement citySelect = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/form/div/div[1]/div[1]/div[1]/div/div/div[2]/div/ul/li[4]"));
		citySelect.click();

		WebElement destinationCity = driver.findElement(By.name("search_form[destination_city]"));
		destinationCity.click();
		city = "Vancouver, BC / Bellingham, WA (BLI)";
		citySelect = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/form/div/div[1]/div[1]/div[2]/div/div/div[2]/div/ul/li[1]"));
		citySelect.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		WebElement departDate= driver.findElement(By.name("search_form[departure_date]"));
		departDate.click();
		String day = "22";
		WebElement daySelect = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div/div/div/div[2]/table/tbody/tr[4]/td[6]/a"));
		daySelect.click();

		WebElement ReturnDate = driver.findElement(By.name("search_form[return_date]"));
		ReturnDate.click();
		day = "25";
		daySelect = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/form/div/div[1]/div[2]/div[2]/div/div/div/div[2]/table/tbody/tr[5]/td[2]/a"));
		daySelect.click();
		
		WebElement submit = driver.findElement(By.id("submit-search"));
		submit.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		WebElement flights = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div[6]/div[3]/button"));
		flights.click();
/*
		WebElement bundle = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[1]/div/button"));
		bundle.click();

		WebElement cars = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div/div[1]/div/div[4]/div/div[3]/div[3]/div/button"));
		cars.click();
*/
	}
		
}
