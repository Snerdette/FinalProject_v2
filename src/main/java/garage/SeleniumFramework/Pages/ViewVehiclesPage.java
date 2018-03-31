package garage.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import garage.SeleniumFramework.PageObject;

public class ViewVehiclesPage extends PageObject {
	
    public ViewVehiclesPage(WebDriver driver) {
		super(driver);
        goTo(URL + "/createVehicle");

    }

}
