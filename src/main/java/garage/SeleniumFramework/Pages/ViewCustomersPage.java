package garage.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import garage.SeleniumFramework.PageObject;

public class ViewCustomersPage extends PageObject {
	
    public ViewCustomersPage(WebDriver driver) {
		super(driver);
        goTo(URL + "/createVehicle");

    }

}
