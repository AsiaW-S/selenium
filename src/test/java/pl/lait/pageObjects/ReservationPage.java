package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.selenium.Init;

public class ReservationPage {  // dotyczy kroku 1
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]"
					+ "/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[1]")
	WebElement roundTripRadio;
	
	@FindBy(name = "passCount")  // tu nie ma średnika, bo to adnotacja; @FindBy zwraca nam WebElement
	WebElement passCountSelect;
	
	@FindBy(name = "fromPort")  // tu nie ma średnika, bo to adnotacja
	WebElement fromPortSelect;	
	
	@FindBy(name = "fromMonth")  // tu nie ma średnika, bo to adnotacja
	WebElement fromMonthSelect;	
	
	@FindBy(name = "fromDay")  // tu nie ma średnika, bo to adnotacja
	WebElement fromDaySelect;	
	
	@FindBy(name = "toPort")  // tu nie ma średnika, bo to adnotacja
	WebElement toPortSelect;	
	
	@FindBy(name = "toMonth")  // tu nie ma średnika, bo to adnotacja
	WebElement toMonthSelect;	
	
	@FindBy(name = "toDay")  // tu nie ma średnika, bo to adnotacja
	WebElement toDaySelect;	
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody"
			+ "/tr[4]/td/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input")
	WebElement economyClassRadio;
	
	@FindBy(name = "airline")
	WebElement airlineSelect;
	
	@FindBy(name = "findFlights")
	WebElement findFlightsBtn; // btn - button, żeby wiedzieć, czego dotyczy
	
	public ReservationPage() {  // konstruktor
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);  // mechanizm spięty na sztywno z @FindBy  - inicjalizacja tych elementów
	}
	
	public void fillTheReservationForm() {  // chodzi o wypełnienie formularza na stronie rezerwacja
		roundTripRadio.click();
		Select passCount = new Select(passCountSelect);
		passCount.selectByVisibleText("2");
		Select fromPort = new Select (fromPortSelect);
		fromPort.selectByVisibleText("London");
		Select fromMonth = new Select(fromMonthSelect);
		fromMonth.selectByVisibleText("August");
		Select fromDay = new Select(fromDaySelect);
		fromDay.selectByVisibleText("5");
		
		Select toPort = new Select (toPortSelect);
		toPort.selectByVisibleText("Paris");
		Select toMonth = new Select(toMonthSelect);
		toMonth.selectByVisibleText("August");
		Select toDay = new Select(toDaySelect);
		toDay.selectByVisibleText("6");
		
		economyClassRadio.click();
		
		Select airline = new Select(airlineSelect);
		airline.selectByVisibleText("Blue Skies Airlines");
		
		findFlightsBtn.click();
		
		
	}
	
}
