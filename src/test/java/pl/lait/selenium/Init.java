package pl.lait.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {  //klasa

	static WebDriver driver = null;  // zmienna statyczna driver, WebDriver to typ zmiennej driver
	
	public static WebDriver getDriver() {  // metoda, która zwraca zmienna typu WebDriver
		System.setProperty("webdriver.gecko.driver", "/home/mariusz/Dokumenty/geckodriver/geckodriver");  //property = właściwość
		URL url = null;  // zmienna obiektowa typu URL o nazwie url
			try {
				url = new URL("http://192.168.0.107:4444/wd/hub");  // // konstruktor URL; wystarczy napisać to i wybrać opcję Surround with try/catch
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		DesiredCapabilities cap = DesiredCapabilities.chrome();  // utworzenie obiektu; zamiast chrome było wcześniej firefox
		if (driver == null) {    // po to żeby nie otwierało się wiele okien Firefox
			//driver = new FirefoxDriver(cap);
			driver = new RemoteWebDriver(url, cap);
			driver.get("http://newtours.demoaut.com");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Określa czas, jaki sterownik powinien poczekać na 
																			//wyszukanie elementu, jeśli nie jest on natychmiast obecny.
			//driver.manage().window().maximize();  // powiększa okno przeglądarki, jeśli jeszcze nie jest powiększone 
			return driver;
		} else {
			return driver;
		}
		
	}
	
	public static void endTest() {
		driver.quit();
		driver = null;
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