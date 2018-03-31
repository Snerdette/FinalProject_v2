package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.VehicleDao;
import garage.entities.Vehicle;

@Repository
@Transactional
public class VehicleDaoImpl implements VehicleDao {

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Returns all the Vehicle objects in the database
	 * @return List<Vehicle> of all vehicles.
	 */
	@Override
	public List<Vehicle> getVehicleData() {
		return em.createQuery("SELECT t FROM vehicle t", Vehicle.class)
				.getResultList();
	}
	
	/**
	 * Adds a new Vehicle object that was created through the UI.
	 * @param vehicle added to database
	 */
	@Override
	public void add(Vehicle vehicle) {
		em.persist(vehicle);
	}
	
	/**
	 * Updates a Vehicle object with changes sent from the UI.
	 * @param vehicle.
	 */
	@Override
	public void update(Vehicle vehicle) {
		em.merge(vehicle);
	}
	
	/**
	 * Retrieves a single Vehicle object.
	 * @param id
	 * @return a single vehicle
	 */
	@Override
	public Vehicle getVehicle(Integer vehicleId) {
		return em.createQuery("SELECT e FROM vehicle e WHERE e.id = :id", Vehicle.class)
				.setParameter("id", vehicleId)
				.getSingleResult();
	}

	/*@Override
	public void delete(Vehicle vehicle) {
		em.merge(vehicle);	
	}*/
	
	/**
	 * Deletes a Vehicle object from the database located with given id.
	 * @param id.
	 */
	@Override
	public void delete(Integer vehicleId) {
		Vehicle vehicle = getVehicle(vehicleId);
		em.remove(vehicle);
	}

}
