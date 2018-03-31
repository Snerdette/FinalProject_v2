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

import garage.dao.ModelDao;
import garage.entities.Model;
import garage.services.InvalidInputException;

public class ModelServiceImplTest {


	private ModelServiceImpl target;
	private ModelDao mockEm;
	
	/**
	 * Setting up the ModelDataServiceImpl for testing
	 */
	@Before
	public void setup(){
		target = new ModelServiceImpl();
		mockEm = mock(ModelDao.class);
		target.setModelDao(mockEm);
	}
	
	/**
	 * Testing the ModelDataServiceImpl for getting a list of all the Modeles.
	 */
	@Test
	public void testGetAllModels(){
		target.setModelDao(mockEm);
		List<Model> expected = new ArrayList<Model>();
		when(mockEm.getModelData()).thenReturn(expected);
		List<Model> actual = target.getModelData();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Testing the ModelDataServiceImpl for get(Model model);
	 */
	@Test
	public void testGetModelObjectById(){
		target.setModelDao(mockEm);
		Model expected = new Model();
		when(mockEm.getModelById(anyInt())).thenReturn(expected);
		Model actual = null;
		
		try {
			actual = target.getModelById(3);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		assertEquals(actual, expected);	
	}
 
	/**
	 * Testing the ModelDataServiceImpl for get(Model model);
	 */
	@Test
	public void testGetModelObjectByNullIdSadPath(){
		target.setModelDao(mockEm);
		Model expected = new Model();
		expected.setId(null);
		when(mockEm.getModelById(anyInt())).thenReturn(expected);
		Model actual = null;
		
		try {
			actual = target.getModelById(null);
		} catch (InvalidInputException e) {
/*			e.printStackTrace();*/
		}
		assertEquals(actual, expected);	
	}
	
	@Test
	public void testGetModelsForMakeTestHappyPath() throws InvalidInputException{
		target.setModelDao(mockEm);
		List<Model> expected = new ArrayList<Model>();
		when(mockEm.getModelsForMake(1)).thenReturn(expected);
		List<Model> actual = target.getModelsForMake(1);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetModelsForMakeTestWithNullSadPath() throws InvalidInputException{
		target.setModelDao(mockEm);
		List<Model> expected = new ArrayList<Model>();
		when(mockEm.getModelsForMake(null)).thenReturn(expected);
		List<Model> actual = target.getModelsForMake(null);
		
		assertEquals(expected, actual);
	}
	
}
