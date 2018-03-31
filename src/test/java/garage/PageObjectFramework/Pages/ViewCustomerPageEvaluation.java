package garage.PageObjectFramework.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.dao.CustomerDao;
import garage.utility.SeleniumConstants;
import garage.validation.CustomerServiceValidation;

public class ViewCustomerPageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	private CustomerServiceValidation target;
	private CustomerDao mockCustomerDao;
	
	@Test
	public void navigateToViewCustomersPage(){
		driver.get(URL + "/");	
	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("viewCustomers"))).click();

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/viewCustomers"), URL );
	}

}
