package garage.SeleniumFramework.Pages;

import org.openqa.selenium.WebDriver;

import garage.SeleniumFramework.PageObject;

public class CreateCustomerPage extends PageObject {
	
    public CreateCustomerPage(WebDriver driver) {
		super(driver);
        goTo(URL + "/createCustomer");

    }
   /* public void clickOnCatalogToEnableUpdate(){
        click(By.id("createProjectBtn")); // click on the first catalog number.
    } */

}
