package garage.dao.impl;

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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import garage.entities.Model;

public class ModelDaoImlTest {


	private ModelDaoImpl target;
	private EntityManager mockEm;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	//Setting up for Model Dao Tests
	@Before
	public void setup(){
		target = new ModelDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	//Tests what gets called when GetModelData
		@SuppressWarnings("unchecked")
		@Test
		public void testGetModelData(){
			List<Model> expected =  new ArrayList<Model>();
			TypedQuery<Model> mockedTypedQuery = mock(TypedQuery.class);
			
			when(mockEm.createQuery(anyString(), eq(Model.class))).thenReturn(mockedTypedQuery);
			when(mockedTypedQuery.getResultList()).thenReturn(expected);
			
			target.getModelData();
			
			verify(mockedTypedQuery, times(1)).getResultList();		
		}
		
		//Tests what gets called when getModelsForMake is called.
		@SuppressWarnings("unchecked")
		@Test
		public void testGetModelsForMake(){
			List<Model> expected =  new ArrayList<Model>();
			TypedQuery<Model> mockedTypedQuery = mock(TypedQuery.class);
			
			when(mockEm.createQuery(anyString(), eq(Model.class))).thenReturn(mockedTypedQuery);
			when(mockedTypedQuery.getResultList()).thenReturn(expected);
			
			target.getModelsForMake(2);
			
			verify(mockedTypedQuery, times(1)).getResultList();		
		}
		
		@Test
		public void testGetModel(){
			TypedQuery<Model> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Model.class))).thenReturn(mockTypedQuery);
			when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
			
			target.getModelById(0);
			verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));		
		}
	
	
}
