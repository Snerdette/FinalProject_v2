package garage.dao.impl;

import static org.junit.Assert.assertFalse;
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
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import garage.entities.Vehicle;

public class VehicleDaoImplTest {


	private VehicleDaoImpl target;
	private EntityManager mockEm;
	
	//Setting up for VehicleDao Tests
	@Before
	public void setup(){
		target = new VehicleDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	//Tests what gets called when GetVehicleData
		@SuppressWarnings("unchecked")
		@Test
		public void testGetVehicleData(){
			List<Vehicle> expected =  new ArrayList<Vehicle>();
			TypedQuery<Vehicle> mockedTypedQuery = mock(TypedQuery.class);
			
			when(mockEm.createQuery(anyString(), eq(Vehicle.class))).thenReturn(mockedTypedQuery);
			when(mockedTypedQuery.getResultList()).thenReturn(expected);
			
			target.getVehicleData();
			
			verify(mockedTypedQuery, times(1)).getResultList();		
		}
		
		/**
		 * Tests that a vehicle is persisted when add(Vehicle vehicle) is called
		 */
		@Test
		public void testAddVehicleAndPersistToDatabase(){
			Vehicle vehicle = new Vehicle();
			target.add(vehicle);
			verify(mockEm, times(1)).persist(vehicle);
		}
		
		@Test
		public void testRemoveVehicleByIdFromDatabase(){
			Vehicle vehicle = new Vehicle();
			boolean result = true;
			vehicle.setId(2);
			target.add(vehicle);
			target.delete(vehicle.id);
			try{
				vehicle.getId();
				result = false;
			}catch(NullPointerException npe){
				result = true;
			}
			assertFalse(result);
		}
		
		@Test
		public void testUpdateVehicleById(){
			Vehicle vehicle = new Vehicle();
			target.update(vehicle);
			verify(mockEm, times(1)).merge(vehicle);
		}
		
		@Test
		public void testGetVehicle(){
			@SuppressWarnings("unchecked")
			TypedQuery<Vehicle> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Vehicle.class))).thenReturn(mockTypedQuery);
			when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
			
			target.getVehicle(0);
			verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));		
		}
}
