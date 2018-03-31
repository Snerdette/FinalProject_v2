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

import garage.entities.Make;

public class MakeDaoImlTest {


	private MakeDaoImpl target;
	private EntityManager mockEm;
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	//Setting up for Make Dao Tests
	@Before
	public void setup(){
		target = new MakeDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	//Tests what gets called when GetMakeData
		@SuppressWarnings("unchecked")
		@Test
		public void testGetMakeData(){
			List<Make> expected =  new ArrayList<Make>();
			TypedQuery<Make> mockedTypedQuery = mock(TypedQuery.class);
			
			when(mockEm.createQuery(anyString(), eq(Make.class))).thenReturn(mockedTypedQuery);
			when(mockedTypedQuery.getResultList()).thenReturn(expected);
			
			target.getMakeData();
			
			verify(mockedTypedQuery, times(1)).getResultList();		
		}
		
		@Test
		public void testGetMake(){
			TypedQuery<Make> mockTypedQuery = mock(TypedQuery.class);

			when(mockEm.createQuery(anyString(), eq(Make.class))).thenReturn(mockTypedQuery);
			when(mockTypedQuery.setParameter(anyString(), anyInt())).thenReturn(mockTypedQuery);
			
			target.getMakeById(0);
			verify(mockTypedQuery, times(1)).setParameter(eq("id"), eq(0));		
		}
}
