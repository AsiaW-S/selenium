package pl.lait.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Init {

	static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", "/home/mariusz/Dokumenty/geckodriver/geckodriver");

		DesiredCapabilities cap = DesiredCapabilities.firefox();

		driver = new FirefoxDriver(cap);
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static void endTest() {
		driver.quit();
	}
	
	public static void sleep(int seconds) { // metoda, która "śpi" - usypia program na chwilę, żeby nie przeciążyć serwera 
											// i móc obserwować ruch na stronie
											// ta metoda w Init jest reużywalna, gdyby była w LoginTest, 
											// to w każdej odrębnej klasie trzebaby było wklejać te klasę
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //end catch

	} //end sleep
} // end class