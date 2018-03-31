package garage.services.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import garage.dao.CustomerDao;
import garage.entities.Customer;
import garage.services.InvalidInputException;


public class CustomerServiceImplTest {


	private CustomerServiceImpl target;
	private CustomerDao mockEm;
	
	/**
	 * Setting up the CustomerDataServiceImpl for testing
	 */
	@Before
	public void setup(){
		target = new CustomerServiceImpl();
		mockEm = mock(CustomerDao.class);
		target.setCustomerDao(mockEm);
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for getting a list of all the Customers.
	 */
	@Test
	public void testGetAllCustomeres(){
		target.setCustomerDao(mockEm);
		List<Customer> expected = new ArrayList<Customer>();
		when(mockEm.getCustomerData()).thenReturn(expected);
		List<Customer> actual = target.getCustomerData();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for get(Customer customer);
	 */
	@Test
	public void testGetCustomerObjectById(){
		target.setCustomerDao(mockEm);
		Customer expected = new Customer();
		when(mockEm.getCustomer(anyInt())).thenReturn(expected);
		Customer actual = null;
		
		try {
			actual = target.getCustomer(3);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
 
	/**
	 * Testing the CustomerDataServiceImpl for get(Customer customer);
	 */
	@Test
	public void testGetCustomerObjectByNullIdSadPath(){
		target.setCustomerDao(mockEm);
		Customer expected = new Customer();
		expected.setId(null);
		when(mockEm.getCustomer(null)).thenReturn(expected);
		Customer actual = null;
		
		try {
			actual = target.getCustomer(null);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected);	
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for adding a customer.
	 */
	@Test
	public void testAddCustomerObject(){
		Customer customer = new Customer();
		customer.setId(2);
		customer.setFirstName("testFirst");
		customer.setLastName("testLast");
		customer.setEmail("test@Email.com");
		customer.setPhone("503-123-4567");
		
		target.add(customer);
		verify(mockEm, times(1)).add(customer);
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for update Customer.
	 */
	@Test
	public void testUpdateCustomerObjectHappy(){
		Customer customer = new Customer();
		target.update(customer);	
	}
	
	/**
	 * Testing the CustomerDataServiceImpl for delete Customer.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testDeletingCustomerObjectById() throws InvalidInputException{
		Customer customer = new Customer();
		customer.setId(2);
		target.delete(2);
		
		boolean result = false;
		try{
			target.getCustomer(2);
			result = false;
		}catch (NullPointerException npe){
			result = true;
		}
		verify(mockEm, times(1)).getCustomer(2);
	}
	
	//Need to try adding a customer with a null id
	@Test
	public void testAddingCustomerWithNullIdSadPath() {
		Customer customer = new Customer();
		customer.setId(null);
		
		boolean result = false;
		try {
			target.getCustomer(null);
			result = true;
			
		}catch(InvalidInputException iie){
			result = false;
			
		}
		assertFalse(result);
		
	}
	
	//Need to try adding a customer with a null value for customer
		@Test
		public void testAddingCustomerWithNullCustomerValueSadPath() {
			@SuppressWarnings("unused")
			Customer customer = new Customer();
			customer = null;
			
			boolean result;
			try {
				target.add(null);
				result = true;
				
			}catch(DataIntegrityViolationException dive){
				result = false;
				
			}
			assertFalse(result);
			
		}
		
		//Need to try updating a customer with a null value for customer
		@Test
		public void testUpdatingCustomerWithNullCustomerValueSadPath() {
			@SuppressWarnings("unused")
			Customer customer = new Customer();
			customer = null;
			
			boolean result;
			try {
				target.update(null);
				result = true;
				
			}catch(DataIntegrityViolationException dive){
				result = false;
				
			}
			assertFalse(result);
			
		}
}
