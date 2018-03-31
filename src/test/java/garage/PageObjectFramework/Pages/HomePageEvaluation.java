package garage.PageObjectFramework.Pages;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.utility.SeleniumConstants;

public class HomePageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();

	@Test
	public void testBasicNavigationOnLoadToHomePage(){
		driver.get(URL + "/");
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.className("displayBox")));
        String actual = driver.getCurrentUrl();
        new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.className("displayBox")));
        Assert.assertEquals(("http://localhost:8080/#/home"), actual );
	}
}
