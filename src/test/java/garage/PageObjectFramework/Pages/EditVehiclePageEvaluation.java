package garage.PageObjectFramework.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.dao.VehicleDao;
import garage.utility.SeleniumConstants;
import garage.validation.VehicleServiceValidation;

public class EditVehiclePageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	private VehicleServiceValidation target;
	private VehicleDao mockVehicleDao;
	
	@Test
	public void navigateToEditVehiclePage(){
		driver.get(URL + "/");	
	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("viewVehicles"))).click();
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.className("editButton"))).click();

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/editVehicle/1"), URL );
	}

}
