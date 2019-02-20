package CleverNumbers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookaNumber {
	
	static WebDriver driver;
	@BeforeMethod
	public static void suitesetup()
	{
				
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.moneypenny.com/uk/");
		String exptitle = driver.getTitle();
		String acttitle = "Moneypenny: Answering Services from the World’s Leading Provider";
		Assert.assertEquals(exptitle, acttitle);
		
		}
	
	//Booking a Single Regional Number for New Customer
	@Test
	public static void BookingaNumber()  {

    try {
		Properties prop= new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\hp\\git\\Moneypenny\\Moneypenny\\src\\com\\bookanumber\\ConfigCleverNumber.properties");
		prop.load(ip);
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("more")));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath(prop.getProperty("clevernumbers"))).click();
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		WebElement region = driver.findElement(By.id("numberSearch"));
		region.sendKeys("0161 - Manchester");
		Thread.sleep(5000);
		WebElement region1 = driver.findElement(By.id("btnFilter"));
		region1.click();
		driver.switchTo().frame("designstudio-iframe");
		driver.findElement(By.id("icon-close")).click();
		driver.findElement(By.xpath("(//ul[@class='cn-numbers-list']//li[1]/label)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnPickNumbers")).click();
		WebElement routenum= driver.findElement(By.xpath("//input[@class='route-number-input']"));
		routenum.sendKeys("07712 258 654");
		driver.findElement(By.xpath("//button[@id='btnRouteNumbers']")).click();
		driver.findElement(By.xpath("//button[@id='btnCheckout']")).click();
		driver.findElement(By.id("register-first-name")).sendKeys("Hari");
		driver.findElement(By.id("register-last-name")).sendKeys("testIndia");
		driver.findElement(By.id("register-company")).sendKeys("Apgomitest");
		driver.findElement(By.id("register-phone")).sendKeys("07712 364 526");
		driver.findElement(By.id("register-email")).sendKeys("moneypennytest+cnindia@gmail.com");
		driver.findElement(By.id("register-password")).sendKeys("test12345");
		driver.findElement(By.id("register-password-confirm")).sendKeys("test12345");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
		driver.findElement(By.id("btnRegister")).click();
		driver.findElement(By.id("btnCheckout")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception is " + e.getMessage());
	
	}
	
	}
	
	
	//Booking a multi number
	@Test
	public static void MultiNumberBooking()  {

    try {
		Properties prop= new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\hp\\git\\Moneypenny\\Moneypenny\\src\\com\\bookanumber\\ConfigCleverNumber.properties");
		prop.load(ip);
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("more")));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath(prop.getProperty("clevernumbers"))).click();
		((JavascriptExecutor)driver).executeScript("scroll(0,800)");
		WebElement region = driver.findElement(By.id("numberSearch"));
		region.sendKeys("0161 - Manchester");
		Thread.sleep(5000);
		WebElement region1 = driver.findElement(By.id("btnFilter"));
		region1.click();
		driver.switchTo().frame("designstudio-iframe");
		driver.findElement(By.id("icon-close")).click();
		driver.findElement(By.xpath("(//ul[@class='cn-numbers-list']//li[1]/label)[1]")).click();
		driver.findElement(By.xpath("(//ul[@class='cn-numbers-list']//li[2]/label)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnPickNumbers")).click();
		WebElement routenum= driver.findElement(By.xpath("(//input[@class='route-number-input'])[1]"));
		routenum.sendKeys("07712 258 654");
		WebElement routenum1= driver.findElement(By.xpath("(//input[@class='route-number-input'])[2]"));
		routenum1.sendKeys("07712 258 654");
		driver.findElement(By.xpath("//button[@id='btnRouteNumbers']")).click();
		driver.findElement(By.xpath("//button[@id='btnCheckout']")).click();
		driver.findElement(By.id("register-first-name")).sendKeys("Ravindra");
		driver.findElement(By.id("register-last-name")).sendKeys("testIndialname");
		driver.findElement(By.id("register-company")).sendKeys("Apgomitest");
		driver.findElement(By.id("register-phone")).sendKeys("07712 364 526");
		driver.findElement(By.id("register-email")).sendKeys("moneypennytest+cnindia1@gmail.com");
		driver.findElement(By.id("register-password")).sendKeys("test1234");
		driver.findElement(By.id("register-password-confirm")).sendKeys("test1234");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[1]")).click();
		driver.findElement(By.id("btnRegister")).click();
		driver.findElement(By.id("btnCheckout")).click();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception is " + e.getMessage());
	
	}
	
	}
	
	@AfterMethod
	public static void suiteteardown()
	{
		driver.quit();
		
	}
	
}
