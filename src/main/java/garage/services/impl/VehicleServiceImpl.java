package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.VehicleDao;
import garage.entities.Customer;
import garage.entities.Vehicle;
import garage.services.InvalidInputException;
import garage.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleDao vehicleDao;
	

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	/**
	 * Retrieves all the Vehicle objects in the database.
	 * @return List<Vehicle> of all vehicles.
	 */
	@Override
	public List<Vehicle> getVehicleData() {
		List<Vehicle> vehicle = vehicleDao.getVehicleData();
		List<Vehicle> allVehicle = new ArrayList<>();
		
		for (Vehicle e : vehicle) {
			allVehicle.add(e);
		}
		return allVehicle;
	}

	/**
	 * Retrieves a single Vehicle object located by the given id.
	 * @param id
	 * @return a single vehicle
	 */	
	@Override
	public Vehicle getVehicle(Integer vehicleId) throws InvalidInputException {
		if (vehicleId == null || vehicleId < 0) {
			throw new InvalidInputException("vehicleId.NullOrNegative");
		}
		return vehicleDao.getVehicle(vehicleId);
	}

	/**
	 * Adds a new Vehicle object that was created through the UI.
	 */
	@Override
	public void add(Vehicle vehicle) {
		if (vehicle == null) {
			throw new DataIntegrityViolationException("Vehicle number is null");
		}else{
			vehicleDao.add(vehicle);
		}		
	}
	
	/**
	 * Adds a new Vehicle object to the database that was created through the UI.
	 * @param vehicle
	 * @return 
	 */
	@Override
	public void update(Vehicle vehicle) {
		if (vehicle == null) {
			throw new DataIntegrityViolationException("Vehicle number is null");
		}else{
			vehicleDao.update(vehicle);
		}	
	}
	
	/**
	 * Deletes a Vehicle object from the database located by the given id.
	 */
	@Override
	public void delete(Integer vehicleId) {
		vehicleDao.delete(vehicleId);
	}
	
}
