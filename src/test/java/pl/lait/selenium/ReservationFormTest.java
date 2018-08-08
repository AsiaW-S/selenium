package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.Reservation2Page;
import pl.lait.pageObjects.Reservation3Page;
import pl.lait.pageObjects.ReservationPage;


public class ReservationFormTest {

	WebDriver driver;
	
	@Before
	public void openPage() {
		driver = Init.getDriver();
	}
	
	@Test
	public void loginWithPageObject() {			//dzięki tem mam dostęp do wszystkich metod klasy LoginPage
		LoginPage loginPage = new LoginPage();  // 
	
		loginPage.goToLoginPage();
		loginPage.loginAs("Asiaws", "qwe123");
		
		ReservationPage reservPage = new ReservationPage(); 
		reservPage.fillTheReservationForm();
		Init.sleep(2);
		Reservation2Page reserv2Page = new Reservation2Page();
		reserv2Page.chooseFlights();
		Init.sleep(2);
		Reservation3Page reserv3Page = new Reservation3Page();
		reserv3Page.fillTheReservation3Form("Al", "Banks", "Jan", "Nowak", "158690");
		Init.sleep(2);
		
		Reservation3Page reserv4Page = new Reservation3Page();
		reserv3Page.flightConfirm();
		Init.sleep(2);
	} // end loginWithPageObject
		
	
	@After
	public void tearDown() {
		Init.endTest();
		
	} //end tearDown
	
} // end class
