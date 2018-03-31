package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Vehicle;
import garage.services.InvalidInputException;
import garage.services.VehicleService;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	public void setVehicleService(VehicleService vehicleService){
		this.vehicleService = vehicleService;
	}
	
	/**
	 * Retrieves all the Vehicles in the database.
	 * @return List<Vehicle> of all vehicles in the database.
	 */
	@RequestMapping(value="/vehicle", method=RequestMethod.GET)
	public List<Vehicle> getVehicleData(){
		return vehicleService.getVehicleData();
	}
	
	/**
	 * Retrieves the Vehicle object by the given id.
	 * @param id
	 * @return single vehicle.
	 * @throws InvalidInputException
	 */
	@RequestMapping(value="/vehicle/{id}", method=RequestMethod.GET)
	public Vehicle getVehicle(@PathVariable Integer id)throws InvalidInputException{
		return vehicleService.getVehicle(id);
	}
	
	/**
	 * Adds a new Vehicle object to the database that was created through the UI
	 * @param vehicle
	 */
	@RequestMapping(value="/vehicle", method=RequestMethod.POST)  
	public void add(@RequestBody Vehicle vehicle) { 
		System.out.println(vehicle);
		vehicleService.add(vehicle);
	}
	
	/**
	 * Performs an update sent from the UI on the Vehicle object located with the given id.
	 * @param id
	 * @param vehicle
	 */
	@RequestMapping(value="/vehicle/{id}", method=RequestMethod.PUT)
	public void updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle){ 
		vehicle.setId(id);
		vehicleService.update(vehicle);
	}
	
	/**
	 * Removes a Vehicle object from the database located by the given id.
	 * @param id
	 */
	@RequestMapping(value="/vehicle/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id){
		vehicleService.delete(id);
	}
}
