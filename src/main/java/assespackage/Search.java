package assespackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Search {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
		// Disabling notification
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--disable-notifications");
		
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize(); // Maximize window
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.eazydiner.com/bengaluru?loc=bengaluru");
		
		// Changing the location to Mumbai
		driver.findElement(By.id("srchbar")).click();
//		Thread.sleep(4000l);
		driver.findElement(By.xpath("//a[@href='/mumbai']")).click();

		// Search biryani mall in the search box
		driver.findElement(By.id("home-search")).sendKeys("Biryani Mall");
		Thread.sleep(2000l);
		driver.findElement(By.id("apxor_search")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Biryani Mall")) {
			System.out.println("Correct page is getting displayed");
		}

		
		

	}

}
