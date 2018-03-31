package garage.services;

import java.util.List;
import garage.entities.Customer;

public interface CustomerService {
	
	/**
	 * Returns a single Customer object by id.
	 * @param id
	 * @return a single customer.
	 */
	Customer getCustomer(Integer customerId)throws InvalidInputException;
	
	/**
	 * Returns all the Customer objects in the database.
	 * @return List<Customer> of all customers.
	 */
	public List<Customer> getCustomerData();
	
	/**
	 * Adds a new Customer object to the database.
	 * @param customer
	 * @throws Exception 
	 */
	public void add(Customer customer);
	
	/**
	 * Updates a Customer object in the database.
	 * @param customer
	 */
	public void update(Customer customer);
	

	/**
	 * Deletes Customer object from the database.
	 * @param customerId
	 */
	public void delete(Integer customerId);	
	
}
