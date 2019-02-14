package PocketPhoneSystem;
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

public class StartPackage {
	@Test
	public static void pps() throws IOException{

    Properties prop= new Properties();
	FileInputStream ip= new FileInputStream("C:\\Users\\hp\\git\\Moneypenny\\Moneypenny\\src\\CleverNumbers\\ConfigCleverNumber.properties");
	prop.load(ip);
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	WebElement ele = driver.findElement(By.xpath(prop.getProperty("calls")));
	Actions act= new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.xpath(prop.getProperty("pps"))).click();
	driver.findElement(By.xpath(prop.getProperty("ppsbutton"))).click();
	WebElement pack= driver.findElement(By.xpath("//*[@id=\"form0\"]/div[1]/div[2]/div[2]/div[6]/input"));
	pack.click();

}
}