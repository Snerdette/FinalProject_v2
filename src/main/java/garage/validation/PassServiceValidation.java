package garage.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import garage.dao.CustomerDao;
import garage.dao.PassDao;
import garage.entities.Customer;
import garage.entities.Pass;
import garage.entities.Vehicle;

@Service
public class PassServiceValidation {

	@Autowired
	PassDao passDao;

	
	public boolean validatePass(Pass pass) throws Exception{
		return validatePrice(pass) && validateExpDate(pass) && validateCustomer(pass) && validateVehicle(pass);
	}
	
	public boolean validatePrice(Pass pass) throws Exception {
		boolean result = true;
		double price = pass.getPrice();
		
		if(price == 0){
			result = false;
			throw new Exception("Price value is empty");
		}
		return result;
	}
	
	public boolean validateExpDate(Pass pass) throws Exception {
		boolean result = true;
		try{
			String expDate = pass.getExpDate();
			if(expDate.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("ExpDate is null");
		}
	}
	
	public boolean validateVehicle(Pass pass) throws Exception {
		boolean result = true;
		try{
			Vehicle vehicle = pass.getVehicle();
			if(vehicle.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Vehicle is null");
		}
	}
	
	public boolean validateCustomer(Pass pass) throws Exception{
		boolean result = true;
		try{
			Customer customer = pass.getCustomer();
			if(customer.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Customer is null");
		}
	}
	
	public void setPassDao(PassDao mockPassDao) {
		this.passDao = mockPassDao;
		
	}
}	
