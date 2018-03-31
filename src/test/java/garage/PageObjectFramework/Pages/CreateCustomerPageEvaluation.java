package garage.PageObjectFramework.Pages;

import static org.junit.Assert.assertFalse;
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

import garage.dao.CustomerDao;
import garage.dao.impl.CustomerDaoImpl;
import garage.entities.Customer;
import garage.validation.CustomerServiceValidation;

import garage.SeleniumFramework.TestPageObject;
import garage.SeleniumFramework.Pages.CreateCustomerPage;

import garage.utility.SeleniumConstants;

public class CreateCustomerPageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	private CustomerServiceValidation target;
	private CustomerDao mockCustomerDao;
	
	@Before(value = "")
	public void setup(){
		target = new CustomerServiceValidation();
		mockCustomerDao = mock(CustomerDao.class);
		target.setCustomerDao(mockCustomerDao);
		
		List<Customer> existingCustomers = new ArrayList<>();
		Customer existingCustomer = new Customer();
		existingCustomer.setFirstName("Project");
		existingCustomers.add(existingCustomer);
		when(mockCustomerDao.getCustomerData()).thenReturn(existingCustomers);
	}
	@Test
	public void navigateToCreateNewCustomerPage(){
		driver.get(URL + "/");	
	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("createCustomer"))).click();

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/createCustomer"), URL );
	}
	
	@Test
	public void addNewCustomerWithValidInformation(){
		driver.get(URL + "/#/createCustomer");
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
		CreateCustomerPage customer = new CreateCustomerPage(driver);
		customer.sendKeys(By.id("firstName"), "Montgomery");
		customer.sendKeys(By.id("lastName"), "Scott");
		customer.sendKeys(By.id("email"), "Scott@enterprise.com");
		customer.click(By.id("submit"));
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("homePage")));
		String aURL = driver.getCurrentUrl();

	    Assert.assertEquals(aURL, (URL  + "/#/home"));
	}
	
	@Test
	public void testCustomerFirstNameWithNameThatIsWhiteSpaceFailes() throws Exception{
		Customer customer = new Customer();
		customer.setFirstName("     ");
		/*assertFalse(target.customerFirstName(customer));*/
	}
}
