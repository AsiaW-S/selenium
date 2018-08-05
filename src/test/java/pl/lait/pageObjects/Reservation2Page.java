package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.lait.selenium.Init;

public class Reservation2Page {

	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"
			+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]"
			+ "/tbody/tr[5]/td[1]/input")
	WebElement departRadio2;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"
			+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]"
			+ "/tbody/tr[5]/td[1]/input")
	WebElement returnRadio2;
	
	@FindBy(name = "reserveFlights")
	WebElement reserveFlightsBtn;
	
	public Reservation2Page() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);
	}
	/**
	 * zawsze klika w drugi z kolei
	 */
	public void chooseFlights() {
		departRadio2.click();
		returnRadio2.click();
		Init.sleep(2);
		reserveFlightsBtn.click(); 
		Init.sleep(2);
		
	}
}
