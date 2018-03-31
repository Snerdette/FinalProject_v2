package garage.dao;

import java.util.List;

import garage.entities.Vehicle;

public interface VehicleDao {

	/**
	 * Retrieves a List of all Vehicle objects in the database.
	 * @return List<Vehicle> all vehicles in database.
	 */
	public List<Vehicle> getVehicleData();

	/**
	 * Adds a new Vehicle object to the database.
	 * @param vehicle
	 */
	void add(Vehicle vehicle);
	
	/**
	 * Updates a Vehicle object.
	 * @param vehicle
	 */
	void update(Vehicle vehicle);

	/**
	 * Deletes a Vehicle object.
	 * @param vehicle
	 */
	void delete(Integer vehicleId);
	
	/*void delete(Vehicle vehicle);*/

	/**
	 * Returns a single Vehicle objects located with the given id.
	 * @param vehicleId
	 * @return single vehicle.
	 */
	public Vehicle getVehicle(Integer vehicleId);
}
