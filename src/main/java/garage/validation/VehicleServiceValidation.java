package garage.validation;

import org.springframework.beans.factory.annotation.Autowired;

import garage.dao.VehicleDao;
import garage.entities.Model;
import garage.entities.Vehicle;

public class VehicleServiceValidation {

	@Autowired
	VehicleDao vehicleDao;
	
	public boolean validateVehicle(Vehicle vehicle) throws Exception{
		return validateYear(vehicle) && validateModel(vehicle) && validatePlateNumber(vehicle) && validatePlateState(vehicle) && validateColor(vehicle);
	}
	
	public boolean validateYear(Vehicle vehicle) throws Exception{
		boolean result = true;
		try{
			int year = vehicle.getYear();
			if(year == 0){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Year is null");
		}
	}
	
	public boolean validateModel(Vehicle vehicle) throws Exception{
		boolean result = true;
		try{
			Model model = vehicle.getModel();
			if(model.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Model is null");
		}
	}
	
	public boolean validatePlateNumber(Vehicle vehicle) throws Exception{
		boolean result = true;
		try{
			String plateNumber = vehicle.getPlateNumber().trim();
			if(plateNumber.equals("")){
				result = false;
			}
			return result;
			
		}catch(NullPointerException e){
			throw new Exception("Email Name is null");
		}
	}
	
	public boolean validatePlateState(Vehicle vehicle) throws Exception{
		boolean result = true;
		try{
			String plateState = vehicle.getPlateState().trim();
			if(plateState.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("PlateState is null");
		}
	}
	
	public boolean validateColor(Vehicle vehicle) throws Exception{
		boolean result = true;
		try{
			String color = vehicle.getColor().trim();
			if(color.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("color is null");
		}
	}
	
	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
		
	}
}
