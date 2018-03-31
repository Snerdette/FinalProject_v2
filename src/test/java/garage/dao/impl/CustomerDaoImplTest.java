package garage.dao.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import garage.entities.Customer;

public class CustomerDaoImplTest {

	private CustomerDaoImpl target;
	private EntityManager mockEm;
	
	//Setting up for Customer Dao Tests
	@Before
	public void setup(){
		target = new CustomerDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	//Tests what gets called when GetCustomerData
		@SuppressWarnings("unchecked")
		@Test
		public void testGetAllCustomerList(){
			List<Customer> expected =  new ArrayList<Customer>();
			TypedQuery<Customer> mockedTypedQuery = mock(TypedQuery.class);
			
			when(mockEm.createQuery(anyString(), eq(Customer.class))).thenReturn(mockedTypedQuery);
			when(mockedTypedQuery.getResultList()).thenReturn(expected);
			
			target.getCustomerData();
			
			verify(mockedTypedQuery, times(1)).getResultList();		
		}
		
		/**
		 * Tests that a customer is persisted when add(Customer customer) is called
		 */
		@Test
		public void testAddCustomerAndPersistToDatabase(){
			Customer customer = new Customer();
			target.add(customer);
			verify(mockEm, times(1)).persist(customer);
		}
		
		@Test
		public void testRemoveCustomerByIdFromDatabase(){
			Customer customer = new Customer();
			boolean result = true;
			customer.setId(2);
			target.add(customer);
			target.delete(customer.id);
			try{
				customer.getId();
				result = false;
			}catch(NullPointerException npe){
				result = true;
			}
			assertFalse(result);
		}
		
		@Test
		public void testUpdateCustomerById(){
			Customer customer = new Customer();
			target.update(customer);
			verify(mockEm, times(1)).merge(customer);
		}
		
		@Test
		public void testGetCustomer(){
			TypedQuery<Customer> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Customer.class))).thenReturn(mockTypedQuery);
			when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
			
			target.getCustomer(0);
			verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));		
		}
	
	
}
