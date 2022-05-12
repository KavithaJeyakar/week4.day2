package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindHandl {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		
		//Open home page
		
		driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']//button[@id ='home']")).click();
		
		Set<String> homeWindowHandles = driver.getWindowHandles();
		
		List<String> homeWindowHandlesList = new ArrayList<String>(homeWindowHandles);
		
		String homeOldWindowHanlde = homeWindowHandlesList.get(0);
		
		String homeNewWindowHandle = homeWindowHandlesList.get(1);
		
		//Home page
		
		driver.switchTo().window(homeNewWindowHandle);
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
	//	driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']")).click();
		
		//Main page
		
		driver.switchTo().window(homeOldWindowHanlde);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//Open multiple windows - 4 correct check..
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		
		Set<String> multipleWindowHandles = driver.getWindowHandles();
		
		System.out.println("No of windows open in multiple windows screen :" + multipleWindowHandles.size());
		
		List<String> multipleWindowHandleList = new ArrayList<String>(multipleWindowHandles);
		
		String multiWindHandleListMain = multipleWindowHandleList.get(0);
		String multiWindHandleList1 = multipleWindowHandleList.get(1);
		String multiWindHandleList2 = multipleWindowHandleList.get(2);
		
		driver.switchTo().window(multiWindHandleList1);
		
		System.out.println("1--------MultiWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(multiWindHandleList2);
		
		System.out.println("2--------MultiWindow-------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(multiWindHandleListMain);
		
		System.out.println("3---------MultiWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//Close all except this window Control change only we can click multiple windows. so seperate prog needed?
		
		Set<String> closeWindowHandles = driver.getWindowHandles();
		
		List<String> closeWindowHandlesList = new ArrayList<String>(closeWindowHandles);
		
		String closeWindowHandlesMain = closeWindowHandlesList.get(0);
		String closeWindowHandles1 = closeWindowHandlesList.get(1);
		String closeWindowHandles2 = closeWindowHandlesList.get(2);
		
		driver.switchTo().window(closeWindowHandles1);
		
		System.out.println("1--------CloseWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(closeWindowHandles2);
		
		System.out.println("2---------CloseWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(closeWindowHandlesMain);
		
		System.out.println("3---------CloseWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		//Wait 5 seconds to open the window
		
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		
		Thread.sleep(5000);

		
		Set<String> waitWindowHandles = driver.getWindowHandles();
		
		List<String> waitWindowHandlesList = new ArrayList<String>(waitWindowHandles);
		
		String waitWindowHandlesMain = waitWindowHandlesList.get(0);
		String waitWindowHandles1 = waitWindowHandlesList.get(1);
		String waitWindowHandles2 = waitWindowHandlesList.get(2);
		
		driver.switchTo().window(waitWindowHandles1);
		
		System.out.println("1--------WaitWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(waitWindowHandles2);
		
		System.out.println("2---------WaitWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(waitWindowHandlesMain);
		
		System.out.println("3---------WaitWindow------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	//	driver.close();

		
	}
}
