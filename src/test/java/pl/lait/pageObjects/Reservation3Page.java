package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.selenium.Init;

public class Reservation3Page {
	
	WebDriver driver;
	
	@FindBy(name = "passFirst0")
	WebElement firstName0Input;
	
	@FindBy(name = "passLast0")
	WebElement lastName0Input;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"
			+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]"
			+ "/td/table/tbody/tr[2]/td[3]/select")
	WebElement meal0Select;
	
	@FindBy(name = "passFirst1")
	WebElement firstName1Input;
	
	@FindBy(name = "passLast1")
	WebElement lastNamet1Input;
	
	@FindBy(name = "pass.0.meal")
	WebElement mealSelect;
	
	@FindBy(name = "pass.1.meal")
	WebElement meal1Select;
	
	@FindBy(name = "creditCard")  // wiem, że nie jest to pole obowiązkowe, ale ćwiczenie czyni mistrza ;)
	WebElement cardTypeSelect;
	
	@FindBy(name = "creditnumber")
	WebElement numberInput;
	
	@FindBy(name = "cc_exp_dt_mn")   // wiem, że nie jest to pole obowiązkowe, ale ćwiczenie czyni mistrza ;)
	WebElement expirationMonthSelect;
	
	@FindBy(name = "cc_exp_dt_yr")  // wiem, że nie jest to pole obowiązkowe, ale ćwiczenie czyni mistrza ;)
	WebElement expirationYearSelect;
	/*
	@FindBy(name = "cc_frst_name")
	WebElement firstNameCcInput;
	
	@FindBy(name = "cc_mid_name")
	WebElement middleNameCcInput;
	
	@FindBy(name = "cc_last_name")
	WebElement lastNameCcInput;
	*/
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"
			+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/"
			+ "tbody/tr[15]/td[2]/input")
	WebElement addressCheckBox;
	
	@FindBy(name = "buyFlights")
	WebElement buyFlightsBtn;

	
	public Reservation3Page() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);
	}	// end konstruktor
	
	
	public void fillTheReservation3Form(String firstName1, String lastName1, String firstName2, String lastName2,  String number) {
		firstName0Input.sendKeys(firstName1);
		lastName0Input.sendKeys(lastName1);
		
		Select pass0meal = new Select(mealSelect);
		pass0meal.selectByValue("DBML");
		Init.sleep(2);
		
		firstName1Input.sendKeys(firstName2);
		lastNamet1Input.sendKeys(lastName2);
		
		Select pass1meal = new Select(meal1Select);
		pass1meal.selectByValue("VGML");
		Select creditCard = new Select(cardTypeSelect);
		creditCard.selectByValue("IK");
		Select expirationMonth = new Select(expirationMonthSelect);
		expirationMonth.selectByVisibleText("11");
		Select expirationYear = new Select(expirationYearSelect);
		expirationYear.selectByValue("2005");
		Init.sleep(2);
		
		numberInput.sendKeys(number);
		addressCheckBox.click();
		Init.sleep(4);
		buyFlightsBtn.click();
	} // end fillTheReservation3Form
	
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"
			+ "/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/"
			+ "tbody/tr/td[3]/a/img")
	WebElement logOutBtn;
	
	public void flightConfirm() {
		logOutBtn.click();
	} // end flightConfirm
}// end class


