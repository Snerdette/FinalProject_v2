package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.CustomerDao;
import garage.entities.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
	private EntityManager em; 
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Returns all the Customer objects in the database
	 * @return List<Customer> of all customers.
	 */
	@Override
	public List<Customer> getCustomerData() {
		return em.createQuery("SELECT t FROM customer t", Customer.class)
				.getResultList();
	}
	
	/**
	 * Adds a new Customer object that was created through the UI.
	 * @param customer added to database
	 */
	@Override
	public void add(Customer customer) {
		em.persist(customer);
	}
	
	/**
	 * Updates a Customer object with changes sent from the UI.
	 * @param customer.
	 */
	@Override
	public void update(Customer customer) {
		em.merge(customer);
	}
	
	/**
	 * Retrieves a single Customer object.
	 * @param id
	 * @return a single customer
	 */
	@Override
	public Customer getCustomer(Integer customerId) {
		return em.createQuery("SELECT e FROM customer e WHERE e.id = :id", Customer.class)
				.setParameter("id", customerId)
				.getSingleResult();
	}

	/*@Override
	public void delete(Customer customer) {
		em.merge(customer);	
	}*/
	
	/**
	 * Deletes a Customer object from the database located with given id.
	 * @param id.
	 */
	@Override
	public void delete(Integer customerId) {
		Customer customer = getCustomer(customerId);
		em.remove(customer);
	}

}
