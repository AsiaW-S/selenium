package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.Reservation2Page;
import pl.lait.pageObjects.ReservationPage;
/**
 * Ten kod służy do utrzymania w dłuższym okresie i przy wielu elementach 
 *
 */
public class Login2Test {
	
	WebDriver driver;  // może być też WebDriver driver = null;
	
	@Before
	public void openPage() {
		driver = Init.getDriver();
	}
	
	@Test 
	public void loginWithPageObject() {			//dzięki tem mam dostęp do wszystkich metod klasy LoginPage
		LoginPage loginPage = new LoginPage();  // 
	//typ metody  /
		loginPage.goToLoginPage();
		loginPage.loginAs("Asiaws", "qwe123");
		
		ReservationPage reservPage = new ReservationPage(); 
		reservPage.fillTheReservationForm();
		
		Reservation2Page reserv2Page = new Reservation2Page();
		reserv2Page.chooseFlights();
	}


	@After
	public void tearDown() {
		Init.endTest();
		
	}
}
