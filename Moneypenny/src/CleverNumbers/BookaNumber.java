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
import org.testng.annotations.Test;

public class BookaNumber {
	
	@Test
	public static void login() throws IOException{

    Properties prop= new Properties();
	FileInputStream ip= new FileInputStream("C:\\Users\\hp\\git\\Moneypenny\\Moneypenny\\src\\CleverNumbers\\ConfigCleverNumber.properties");
	prop.load(ip);
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	WebElement ele = driver.findElement(By.xpath(prop.getProperty("more")));
	Actions act= new Actions(driver);
	act.moveToElement(ele).perform();
	// driver.findElement(By.xpath("//*[@id='more']/ul/a[1]/li/h2")).click();
	driver.findElement(By.xpath(prop.getProperty("clevernumbers"))).click();
	((JavascriptExecutor)driver).executeScript("scroll(0,800)");
	WebElement region = driver.findElement(By.id("numberSearch"));
	region.sendKeys("0203 - London");
	region.sendKeys(Keys.ENTER);
	
	//input[@id='cnCheck1']
	driver.findElement(By.xpath("//input[@id='cnCheck1']")).click();
	
	
	}
}
