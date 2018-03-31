package garage.dao.impl;

import static org.junit.Assert.*;
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

import garage.entities.Pass;

public class PassDaoImplTest {

	private PassDaoImpl target;
	private EntityManager mockEm;
	
	//Setting up for PassDao Tests
	@Before
	public void setup(){
		target = new PassDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	//Tests what gets called when GetPassData
		@SuppressWarnings("unchecked")
		@Test
		public void testGetAllPassList(){
			List<Pass> expected =  new ArrayList<Pass>();
			TypedQuery<Pass> mockedTypedQuery = mock(TypedQuery.class);
			
			when(mockEm.createQuery(anyString(), eq(Pass.class))).thenReturn(mockedTypedQuery);
			when(mockedTypedQuery.getResultList()).thenReturn(expected);
			
			target.getPassData();
			
			verify(mockedTypedQuery, times(1)).getResultList();		
		}
		
		/**
		 * Tests that a pass is persisted when add(Pass pass) is called
		 */
		@Test
		public void testAddPassAndPersistToDatabase(){
			Pass pass = new Pass();
			target.add(pass);
			verify(mockEm, times(1)).persist(pass);
		}
		
		@Test
		public void testRemovePassByIdFromDatabase(){
			Pass pass = new Pass();
			boolean result = true;
			pass.setId(2);
			target.add(pass);
			target.delete(pass.id);
			try{
				pass.getId();
				result = false;
			}catch(NullPointerException npe){
				result = true;
			}
			assertFalse(result);
		}
		
		@Test
		public void testUpdatePassById(){
			Pass pass = new Pass();
			target.update(pass);
			verify(mockEm, times(1)).merge(pass);
		}
		
		@Test
		public void testGetPass(){
			@SuppressWarnings("unchecked")
			TypedQuery<Pass> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Pass.class))).thenReturn(mockTypedQuery);
			when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
			
			target.getPass(0);
			verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));		
		}
}
