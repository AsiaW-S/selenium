package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.lait.selenium.Init;

public class LoginPage {
	
	WebDriver driver;  // pusty koszyczek na Firefoxa
	
	@FindBy(name = "userName")  // skrócona ścieżka dostępu do przycisków
	WebElement loginInput;		// 
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(name = "login")
	WebElement loginBtn;    // Btn - button
	
	@FindBy(linkText = "SIGN-ON")
	WebElement signOnLink;   // 
	
	public LoginPage() {  // konstruktor; przed każdym testem trzeba będzie go wywołać, poprzez utworzenie obiektu
		driver = Init.getDriver();  //
		PageFactory.initElements(driver, this);  // this odwołuje się do własnej klasy
	}
	
	/**
	 * Open login page = click on SIGN-ON link
	 */
			
	public void goToLoginPage() {
		signOnLink.click();
		
	}
	/**
	 * Login user with provided data
	 * @param login
	 * @param password
	 */
	public void loginAs(String login, String password) {
		loginInput.sendKeys(login);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}
}
