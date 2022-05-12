package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContactWindHandl {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/login");
	
	driver.manage().window().maximize();
	
	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	
	driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
	
	driver.findElement(By.className("decorativeSubmit")).click();
	
	driver.findElement(By.linkText("CRM/SFA")).click();
	
	driver.findElement(By.linkText("Contacts")).click();
	
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

	driver.findElement(By.xpath("(//form[@name= 'MergePartyForm']//a//img)[1]")).click();
	
	//From contact
	
	Set<String> windowHandles= driver.getWindowHandles();
	System.out.println(windowHandles);
	
	List<String> windowHandlesList = new ArrayList<String>(windowHandles);
	
	String oldWindowHandle = windowHandlesList.get(0);
	String newWindowHandle = windowHandlesList.get(1);
	
	System.out.println("1-------------------------------------------------");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	System.out.println(oldWindowHandle);
	
	driver.switchTo().window(newWindowHandle);
	
	System.out.println("2-------------------------------------------------");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	System.out.println(newWindowHandle);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		
	driver.switchTo().window(oldWindowHandle); //parent 
	
	System.out.println("3-------------------------------------------------");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	System.out.println(oldWindowHandle);
	Thread.sleep(3000);
	// To Contact
	
	driver.findElement(By.xpath("(//form[@name= 'MergePartyForm']//a//img)[2]")).click();
	
	Set<String> towindowHandles= driver.getWindowHandles();
	System.out.println(towindowHandles);
	
	List<String> towindowHandlesList = new ArrayList<String>(towindowHandles);
	
	String tooldWindowHandle = towindowHandlesList.get(0);
	String tonewWindowHandle = towindowHandlesList.get(1);
	
	driver.switchTo().window(tonewWindowHandle);
	
	System.out.println("4-------------------------------------------------");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	System.out.println(towindowHandlesList); 
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[2]//a")).click();
	
	driver.switchTo().window(tooldWindowHandle); //parent

	driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	
	Alert alert=driver.switchTo().alert();
	alert.accept();
	
	System.out.println(" Title of the page :" + driver.getTitle());
	
	if (driver.getTitle().contains("View Contact")  )
	{
		System.out.println("Title of the page : " + driver.getTitle());
	}
//	driver.close();
}

}
