package garage.dao;

import java.util.List;

import garage.controllers.CustomerController;
import garage.entities.Customer;

public interface CustomerDao {

	/**
	 * Retrieves a List of all Customer objects in the database.
	 * @return List<Customer> all customers in database.
	 */
	public List<Customer> getCustomerData();

	/**
	 * Adds a new Customer object to the database.
	 * @param customer
	 */
	void add(Customer customer);
	
	/**
	 * Updates a Customer object.
	 * @param customer
	 */
	void update(Customer customer);
	
	/**
	 * Deletes a Customer object.
	 * @param customer
	 */
	/*void delete(Customer customer);*/
	
	/**
	 * Deletes a Customer object.
	 * @param customer
	 */
	void delete(Integer customerId);

	/**
	 * Returns a single Customer objects located with the given id.
	 * @param customerId
	 * @return single customer.
	 */
	public Customer getCustomer(Integer customerId);

}
