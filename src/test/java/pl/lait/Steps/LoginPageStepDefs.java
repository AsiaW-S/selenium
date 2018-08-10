package pl.lait.Steps;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*; // było: import cucumber.api.java.en.Given; zmieniamy Given na * i mamy wszystko co znajdzie w środku
// import cucumber.api.java.pl.*;   i mamy język polski
import cucumber.api.java.After;
import pl.lait.pageObjects.LoginPage;
import pl.lait.selenium.Init;

public class LoginPageStepDefs {
	WebDriver driver = Init.getDriver();
	LoginPage loginPage; // zmienna obiektowa loginPage  // LoginPage - strona z guzikami 
	
	
	@Given("^I open main page$")
	public void i_open_main_page() throws Throwable {
	    //już jestem na stronie "main"
	}

	@When("^I click SIGN-ON link$")
	public void i_click_SIGN_ON_link() throws Throwable {
		loginPage = new LoginPage(); // konstruktor
	    loginPage.goToLoginPage();  // 
	}

	@Then("^I should see login page$")
	public void i_should_see_login_page() throws Throwable {
	    System.out.println(driver.getTitle());
	}
	
}
