package garage.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import garage.dao.MakeDao;
import garage.entities.Make;
import garage.services.InvalidInputException;

public class MakeServiceImplTest {


	private MakeServiceImpl target;
	private MakeDao mockEm;
	
	/**
	 * Setting up the MakeDataServiceImpl for testing
	 */
	@Before
	public void setup(){
		target = new MakeServiceImpl();
		mockEm = mock(MakeDao.class);
		target.setMakeDao(mockEm);
	}
	
	/**
	 * Testing the MakeDataServiceImpl for getting a list of all the Makees.
	 */
	@Test
	public void testGetAllMakes(){
		target.setMakeDao(mockEm);
		List<Make> expected = new ArrayList<Make>();
		when(mockEm.getMakeData()).thenReturn(expected);
		List<Make> actual = target.getMakeData();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Testing the MakeDataServiceImpl for get(Make make);
	 */
	@Test
	public void testGetMakeObjectById(){
		target.setMakeDao(mockEm);
		Make expected = new Make();
		when(mockEm.getMakeById(anyInt())).thenReturn(expected);
		Make actual = null;
		
		try {
			actual = target.getMakeById(3);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected);	
	}
 
	/**
	 * Testing the MakeDataServiceImpl for get(Make make);
	 */
	@Test
	public void testGetMakeObjectByNullIdSadPath(){
		target.setMakeDao(mockEm);
		Make expected = new Make();
		expected.setId(null);
		when(mockEm.getMakeById(anyInt())).thenReturn(expected);
		Make actual = null;
		
		try {
			actual = target.getMakeById(null);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected);	
	}
	
}
