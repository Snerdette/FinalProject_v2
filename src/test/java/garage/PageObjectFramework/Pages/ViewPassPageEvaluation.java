package garage.PageObjectFramework.Pages;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.dao.PassDao;
import garage.utility.SeleniumConstants;
import garage.validation.PassServiceValidation;

public class ViewPassPageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	private PassServiceValidation target;
	private PassDao mockPassDao;
	
	@Before(value = "")
	public void setup(){
		target = new PassServiceValidation();
		mockPassDao = mock(PassDao.class);
		target.setPassDao(mockPassDao);
		
	}
	@Test
	public void navigateToViewPassesPage(){
		driver.get(URL + "/");	
	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("viewPasses"))).click();

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/viewPasses"), URL );
	}

}
