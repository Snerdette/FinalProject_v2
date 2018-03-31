package garage.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import garage.SeleniumFramework.PageObject;

public class CreateVehiclePage extends PageObject {
	
    public CreateVehiclePage(WebDriver driver) {
		super(driver);
        goTo(URL + "/createVehicle");

    }

}
