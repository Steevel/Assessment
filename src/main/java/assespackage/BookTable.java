package assespackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class BookTable {

	public static void main(String[] args) throws Throwable {
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
		// Disabling notification
		ChromeOptions option = new ChromeOptions ();
		option.addArguments("--disable-notifications");
		
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize(); // Maximize window
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.eazydiner.com/bengaluru?loc=bengaluru");
		
		int count = driver.findElements(By.xpath("//span[@class='bold grey-dark bucket_name font-14']")).size();
		
		// Click on 'Book a Table'
		for(int i=0;i<count;i++) {
			String text = driver.findElements(By.xpath("//span[@class='bold grey-dark bucket_name font-14']")).get(i).getText();
			
			if(text.contains("Book a Table")) {
				driver.findElements(By.xpath("//span[@class='bold grey-dark bucket_name font-14']")).get(i).click();
				break;
			}
		}
		
		// Select 'Critic Rating' from the sort by drop down
		Select sortBy = new Select(driver.findElement(By.id("res_sort")));
		sortBy.selectByValue("critic_review_rating-desc");
		
		Thread.sleep(2000l);
		// Select second item from the list and click on "Book a Table"
		driver.findElement(By.xpath("(//a[@class='btn btn-primary height-40 block bold padding-10 font-14 apxor_click'])[2]")).click();
		
		// Click on "Continue to book a table
		driver.findElement(By.xpath("//button[@class='h-50 button bold btn-sticky white']")).click();

		// Fill guest information
		driver.findElement(By.id("guest_name")).sendKeys("Name");
		driver.findElement(By.id("guest_email")).sendKeys("Email@email.com");
		driver.findElement(By.xpath("//*[@id=\"guest-form\"]/div/div[2]/div/div/input")).sendKeys("7026059224");

		// Click on "Book Now"
		driver.findElement(By.id("checkout-button")).click();

	}

}
