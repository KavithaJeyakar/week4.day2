package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropDown {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		//Using Index
		
		Select selIndex = new Select(driver.findElement(By.id("dropdown1")));
		
		selIndex.selectByIndex(1);
		
		//Using visible Text
		
		Select selText = new Select(driver.findElement(By.name("dropdown2")));
		
		selText.selectByVisibleText("Appium");
		
		//Using Value
		
		Select selValue = new Select(driver.findElement(By.id("dropdown3")));
		
		selValue.selectByValue("3");
		
		
		//Get the number of drop downs
		
		Select seNoDropDowns = new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));

		List <WebElement> list = seNoDropDowns.getOptions();
		list.size();
		System.out.println("No of drop down values : "+ list.size());
		
		// Send keys
		
		driver.findElement(By.xpath("(//select['multiple'])[5]")).sendKeys("Selenium");
		
		//Multiple programs
		
		Select selPro = new Select (driver.findElement(By.xpath("(//select['multiple'])[6]")));
		selPro.selectByIndex(3);	
		selPro.selectByValue("1");
		
	}

}
