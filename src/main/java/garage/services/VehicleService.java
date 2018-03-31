package garage.services;

import java.util.List;

import garage.entities.Vehicle;

public interface VehicleService {

	/**
	 * Returns a single vehicle object by id.
	 * @param id
	 * @return a single vehicle.
	 */
	Vehicle getVehicle(Integer vehicleId) throws InvalidInputException;
	
	/**
	 * Returns all the vehicles in the database.
	 * @return List<vehicle> of all vehicles.
	 */
	public List<Vehicle> getVehicleData();
	
	/**
	 * Adds a new Vehicle object to the database.
	 * @param vehicle added to database
	 * @throws Exception 
	 */
	public void add(Vehicle vehicle);
	
	/**
	 * Updates a Vehicle object in the database.
	 * @param vehicle
	 */
	public void update(Vehicle vehicle);
	
	/**
	 * Deletes Vehicle object from the database.
	 * @param vehicleId
	 */
	public void delete(Integer vehicleId);
	
}
