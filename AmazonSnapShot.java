package week4.day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSnapShot {
	
@SuppressWarnings("null")
public static void main(String[] args) throws InterruptedException, Exception {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	Thread.sleep(2000);
	WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	search.sendKeys("oneplus 9 pro");
	search.submit();
	Thread.sleep(2000);
	
//	driver.findElement(By.xpath("(//h2//a//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).click();
	
	String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
	System.out.println("Mobile Price :" + price);
	
	String custReview = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();

	System.out.println("Customer Review Ratings :" + custReview); 
	
	driver.findElement(By.xpath("(//h2//a//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
	Set<String> clickHandles = driver.getWindowHandles();
	List<String> clickHandlesList = new ArrayList<String>(clickHandles);
	
	driver.switchTo().window(clickHandlesList.get(1));
		
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	
	File SrcFile = driver.getScreenshotAs(OutputType.FILE);
	
	File DestFile =new File("./SnapsScreenShots/IMG002.png");
	
	FileUtils.copyFile(SrcFile, DestFile);
	
	
	System.out.println("Screen shot taken");
	
	driver.findElement(By.xpath("//span[@class='a-button a-spacing-small a-button-primary a-button-icon']")).submit();
	
	String cartSubTotal = driver.findElement(By.xpath("//div[@id='sw-subtotal']")).getText();
	
	System.out.println("Cart SubTotal Values : "+ cartSubTotal);
	
	driver.close();
	
}	

}
