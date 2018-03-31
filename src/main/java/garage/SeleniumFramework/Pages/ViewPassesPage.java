package garage.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import garage.SeleniumFramework.PageObject;

public class ViewPassesPage extends PageObject {
	
    public ViewPassesPage(WebDriver driver) {
		super(driver);
        goTo(URL + "/createVehicle");

    }

}
