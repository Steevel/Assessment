package assespackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		// Disabling notification
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize(); // Maximize window

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.eazydiner.com/bengaluru?loc=bengaluru");

		// Limit the scope of the driver to first column of footer links
		WebElement footerDriver = driver
				.findElement(By.xpath("(//div[@class='grid footer flex flex-between']//div[@class=''])[1]"));
		int count = footerDriver.findElements(By.tagName("a")).size();
		System.out.println("Number of links " + count);

		// Click on each link and check if they are working by opening them in new tabs
		for (int i = 1; i < count; i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}

		// Switch to each tab and get the title
		System.out.println("-------------------Titles-------------------");
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
