package garage.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import garage.SeleniumFramework.PageObject;

public class CreatePassPage extends PageObject {
	
    public CreatePassPage(WebDriver driver) {
		super(driver);
        goTo(URL + "/createPass");

    }

}
