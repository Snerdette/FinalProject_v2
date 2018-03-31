package garage.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import garage.dao.CustomerDao;
import garage.entities.Customer;


public class CustomerServiceValidation {

	@Autowired
	CustomerDao customerDao;
	
	public boolean validateCustomer(Customer customer) throws Exception{
		return validateFirstName(customer) && validateLastName(customer) && validateEmail(customer) && validatePhone(customer);
	}
	
	public boolean validateFirstName(Customer customer) throws Exception{
		boolean result = true;
		try{
			String firstName = customer.getFirstName().trim();
			if(firstName.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("First Name is null");
		}
	}
	
	public boolean validateLastName(Customer customer) throws Exception{
		boolean result = true;
		try{
			String lastName = customer.getLastName().trim();
			if(lastName.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Last Name is null");
		}
	}
	
	public boolean validateEmail(Customer customer) throws Exception{
		boolean result = true;
		try{
			String email = customer.getEmail().trim();
			if(email.equals("")){
				result = false;
			}
			
			List<Customer> existingCustomers = customerDao.getCustomerData();
			
			for(Customer c : existingCustomers){
				String lowerCaseEmail = email.toLowerCase();
				String lowerCaseExistingEmail = c.getEmail().toLowerCase();
				if(lowerCaseEmail.equals(lowerCaseExistingEmail)){
					result = false;
				}
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Email Name is null");
		}
	}
	
	public boolean validatePhone(Customer customer) throws Exception{
		boolean result = true;
		try{
			String phone = customer.getPhone().trim();
			if(phone.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Phone is null");
		}
	}
	
	public void setCustomerDao(CustomerDao mockCustomerDao) {
		this.customerDao = mockCustomerDao;
		
	}

}
