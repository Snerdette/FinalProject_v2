package garage.PageObjectFramework.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.utility.SeleniumConstants;

public class CreateVehiclePageEvaluation extends TestPageObject {

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	
	@Test
	public void navigateToCreateNewVehiclePage(){
		driver.get(URL + "/");	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("createVehicle"))).click();
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/createVehicle"), URL );
	}
}