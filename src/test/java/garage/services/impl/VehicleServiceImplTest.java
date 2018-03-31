package garage.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import garage.dao.VehicleDao;
import garage.entities.Make;
import garage.entities.Model;
import garage.entities.Vehicle;
import garage.services.InvalidInputException;

public class VehicleServiceImplTest {

	private VehicleServiceImpl target;
	private VehicleDao mockEm;
	
	/**
	 * Setting up the VehicleDataServiceImpl for testing
	 */
	@Before
	public void setup(){
		target = new VehicleServiceImpl();
		mockEm = mock(VehicleDao.class);
		target.setVehicleDao(mockEm);
	}
	
	/**
	 * Testing the VehicleDataServiceImpl for getting a list of all the Vehiclees.
	 */
	@Test
	public void testGetAllVehiclees(){
		target.setVehicleDao(mockEm);
		List<Vehicle> expected = new ArrayList<Vehicle>();
		when(mockEm.getVehicleData()).thenReturn(expected);
		List<Vehicle> actual = target.getVehicleData();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Testing the VehicleDataServiceImpl for get(Vehicle vehicle);
	 */
	@Test
	public void testGetVehicleObjectById(){
		target.setVehicleDao(mockEm);
		Vehicle expected = new Vehicle();
		when(mockEm.getVehicle(anyInt())).thenReturn(expected);
		Vehicle actual = null;
		
		try {
			actual = target.getVehicle(3);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
 
	/**
	 * Testing the VehicleDataServiceImpl for get(Vehicle vehicle);
	 */
	@Test
	public void testGetVehicleObjectByNullIdSadPath(){
		target.setVehicleDao(mockEm);
		Vehicle expected = new Vehicle();
		expected.setId(null);
		when(mockEm.getVehicle(anyInt())).thenReturn(expected);
		Vehicle actual = null;
		
		try {
			actual = target.getVehicle(3);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
	
	/**
	 * Testing the VehicleDataServiceImpl for adding a vehicle.
	 */
	@Test
	public void testAddVehicleObject(){
		Vehicle vehicle = new Vehicle();
		vehicle.setId(2);
		vehicle.setColor("Red");
		vehicle.setPlateNumber("testPlateNumber");
		vehicle.setPlateState("OR");

		
		target.add(vehicle);
		verify(mockEm, times(1)).add(vehicle);
	}
	
	/**
	 * Testing the VehicleDataServiceImpl for update Vehicle.
	 */
	@Test
	public void testUpdateVehicleObjectHappy(){
		Vehicle vehicle = new Vehicle();
		target.update(vehicle);	
	}
	
	/**
	 * Testing the VehicleDataServiceImpl for delete Vehicle.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testDeletingVehicleObjectById() throws InvalidInputException{
		Vehicle vehicle = new Vehicle();
		vehicle.setId(2);
		target.delete(2);
		
		boolean result = false;
		try{
			target.getVehicle(2);
			result = false;
		}catch (NullPointerException npe){
			result = true;
		}
		verify(mockEm, times(1)).getVehicle(2);
	}
	
	//Need to try adding a vehicle with a null id
	@Test
	public void testAddingVehicleWithNullIdSadPath() {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(null);
		
		boolean result = false;
		try {
			target.getVehicle(null);
			result = true;
			
		}catch(InvalidInputException iie){
			result = false;
			
		}
		assertFalse(result);
		
	}
	
	//Need to try adding a vehicle with a null value for vehicle
		@Test
		public void testAddingVehicleWithNullVehicleValueSadPath() {
			@SuppressWarnings("unused")
			Vehicle vehicle = new Vehicle();
			vehicle = null;
			
			boolean result;
			try {
				target.add(null);
				result = true;
				
			}catch(DataIntegrityViolationException dive){
				result = false;
				
			}
			assertFalse(result);
			
		}
		
		//Need to try updating a vehicle with a null value for vehicle
		@Test
		public void testUpdatingVehicleWithNullVehicleValueSadPath() {
			@SuppressWarnings("unused")
			Vehicle vehicle = new Vehicle();
			vehicle = null;
			
			boolean result;
			try {
				target.update(null);
				result = true;
				
			}catch(DataIntegrityViolationException dive){
				result = false;
				
			}
			assertFalse(result);
			
		}
}
