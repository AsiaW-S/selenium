package pl.lait.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App {
	static WebDriver driver;  // globalna zmienna

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.setProperty("webdriver.gecko.driver", "/home/mariusz/Dokumenty/geckodriver/geckodriver");

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		driver = new FirefoxDriver(cap);
		driver.get("http://newtours.demoaut.com");
		sleep(2);
		//driver.findElement(By.linkText("SIGN-ON")).click();
		clickWhenReady(By.linkText("SIGN-ON"), 10);
		sleep(3);
		driver.findElement(By.name("userName")).sendKeys("Asiaws");
		driver.findElement(By.name("password")).sendKeys("qwe123");
		sleep(1);
		driver.findElement(By.name("login")).click();
		driver.quit();
		
		
	}

	public static void sleep(int seconds) { // metoda, która "śpi" - usypia program na chwilę, żeby nie przeciążyć serwera i móc obserwować ruch na stronie
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void clickWhenReady(By locator, int timeout) {

		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();

 }
}
