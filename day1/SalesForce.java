package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("bootCamp@testleaf.com");
	
		driver.findElement(By.id("password")).sendKeys("Sales@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(1000);
		WebElement oppo = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();",oppo);
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[7]")).sendKeys("Salesforce Automation by sangirthiyayan");       
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("9/1/2025");
		driver.findElement(By.xpath("//label[text()='Stage']//following::span")).click();
		//Thread.sleep(500);
		WebElement stage = driver.findElement(By.xpath("(//button//following::span[@title='Needs Analysis'])[4]"));
		//driver.executeScript("arguments[0].click();",stage);
		stage.click();
		driver.findElement(By.name("SaveEdit")).click();
		File source = driver.getScreenshotAs(OutputType.FILE);

		File destination = new File("./salesforce/error.png");

		FileUtils.copyFile(source, destination);
		
		
	}

}
