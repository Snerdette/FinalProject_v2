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
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataIntegrityViolationException;

import garage.dao.PassDao;
import garage.entities.Pass;
import garage.services.InvalidInputException;

public class PassServiceImplTest {



	private PassServiceImpl target;
	private PassDao mockEm;
	
	/**
	 * Setting up the PassDataServiceImpl for testing
	 */
	@Before
	public void setup(){
		target = new PassServiceImpl();
		mockEm = mock(PassDao.class);
		target.setPassDao(mockEm);
	}
	
	/**
	 * Testing the PassDataServiceImpl for getting a list of all the Passes.
	 */
	@Test
	public void testGetAllPasses(){
		target.setPassDao(mockEm);
		List<Pass> expected = new ArrayList<Pass>();
		when(mockEm.getPassData()).thenReturn(expected);
		List<Pass> actual = target.getPassData();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Testing the PassDataServiceImpl for get(Pass pass);
	 */
	@Test
	public void testGetPassObjectById(){
		target.setPassDao(mockEm);
		Pass expected = new Pass();
		when(mockEm.getPass(anyInt())).thenReturn(expected);
		Pass actual = null;
		
		try {
			actual = target.getPass(3);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
 
	/**
	 * Testing the PassDataServiceImpl for get(Pass pass);
	 */
	@Test
	public void testGetPassObjectByNullIdSadPath(){
		target.setPassDao(mockEm);
		Pass expected = new Pass();
		expected.setId(null);
		when(mockEm.getPass(anyInt())).thenReturn(expected);
		Pass actual = null;
		
		try {
			actual = target.getPass(3);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
	
	/**
	 * Testing the PassDataServiceImpl for adding a pass.
	 */
	@Test
	public void testAddPassObject(){
		Pass pass = new Pass();
		pass.setId(2);
		pass.setPrice(99.99);
		
		target.add(pass);
		verify(mockEm, times(1)).add(pass);
	}
	
	/**
	 * Testing the PassDataServiceImpl for update Pass.
	 */
	@Test
	public void testUpdatePassObjectHappy(){
		Pass pass = new Pass();
		target.update(pass);	
	}
	
	/**
	 * Testing the PassDataServiceImpl for delete Pass.
	 */
	@SuppressWarnings("unused")
	@Test
	public void testDeletingPassObjectById() throws InvalidInputException{
		Pass pass = new Pass();
		pass.setId(2);
		target.delete(2);
		
		boolean result = false;
		try{
			target.getPass(2);
			result = false;
		}catch (NullPointerException npe){
			result = true;
		}
		verify(mockEm, times(1)).getPass(2);
	}
	
	//Need to try adding a pass with a null id
	@Test
	public void testAddingPassWithNullIdSadPath() {
		Pass pass = new Pass();
		pass.setId(null);
		
		boolean result = false;
		try {
			target.getPass(null);
			result = true;
			
		}catch(InvalidInputException iie){
			result = false;
			
		}
		assertFalse(result);
		
	}
	
	//Need to try adding a pass with a null value for pass
		@Test
		public void testAddingPassWithNullPassValueSadPath() {
			@SuppressWarnings("unused")
			Pass pass = new Pass();
			pass = null;
			
			boolean result;
			try {
				target.add(null);
				result = true;
				
			}catch(DataIntegrityViolationException dive){
				result = false;
				
			}
			assertFalse(result);
			
		}
		
		//Need to try updating a pass with a null value for pass
		@Test
		public void testUpdatingPassWithNullPassValueSadPath() {
			@SuppressWarnings("unused")
			Pass pass = new Pass();
			pass = null;
			
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
