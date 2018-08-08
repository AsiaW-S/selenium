package pl.lait.selenium;  // ta metoda jest lepsza, jeżeli mamy do przetestowania małą ilość elementów na stronie,

import org.junit.Before;
import org.junit.runners.MethodSorters;
import org.junit.*;   // import org.junit.Test; zamiast Test * i wtedy będzie dostęp do wszystkich innych opcji
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.*;

@Ignore
@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // dzieki temu będzie sortował wg kolejności alfabetycznej
public class LoginTest {
	
	WebDriver driver = null; // pusta zmienna na WebDrivera // import WebDriver
	
	@Before   // przed każdym testem uruchomi się ta metoda
	public void openPage () {
		driver = Init.getDriver();
	}
	
	@Ignore
	@Test
	public void clickOnMenuItems() {
		
		Init.sleep(1);
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.sleep(1);
		driver.findElement(By.linkText("REGISTER")).click();
		Init.sleep(1);
		driver.findElement(By.linkText("SUPPORT")).click();
		Init.sleep(1);
		driver.findElement(By.linkText("CONTACT")).click();
		Init.sleep(1);
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.sleep(1);
		driver.findElement(By.name("userName")).sendKeys("Asiaws");
		driver.findElement(By.name("password")).sendKeys("qwe123");
		Init.sleep(1);
		driver.findElement(By.name("login")).click();
		Init.sleep(1);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		Init.sleep(1);
		
	}
	
	@Test
	public void reservation() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("Asiaws");
		driver.findElement(By.name("password")).sendKeys("qwe123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"  // pole typu radio
				+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
		Init.sleep(2);
		Select passCount = new Select(driver.findElement(By.name("passCount")));  // pole typu select
		passCount.selectByValue("2");  
		Select fromPort = new Select(driver.findElement(By.name("fromPort")));  // pole typu select
		fromPort.selectByValue("Frankfurt");
		
		Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));  // pole typu select
		fromMonth.selectByVisibleText("May");  // ByValue("5"); to też maj
		
		Select fromDay = new Select(driver.findElement(By.name("fromDay")));  // pole typu select
		fromDay.selectByValue("15");
		
		Select toPort = new Select(driver.findElement(By.name("toPort")));  // pole typu select
		toPort.selectByValue("London");
		
		Select toMonth = new Select(driver.findElement(By.name("toMonth")));  // pole typu select
		toMonth.selectByValue("11");
		
	}
	
	@After
	public void tearDown() {  // tearDown - wygaszanie, zamykanie przeglądarki
		Init.sleep(2);
		Init.endTest();
	}
} // end class
