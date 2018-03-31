package garage.PageObjectFramework.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.dao.PassDao;
import garage.utility.SeleniumConstants;
import garage.validation.PassServiceValidation;

public class EditPassPageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	private PassServiceValidation target;
	private PassDao mockPassDao;
	
	@Test
	public void navigateToEditPassPage(){
		driver.get(URL + "/");	
	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("viewPasses"))).click();
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.className("editButton"))).click();

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/editPass/1"), URL );
	}

}
