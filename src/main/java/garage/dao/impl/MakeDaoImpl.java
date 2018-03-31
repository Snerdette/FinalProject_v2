package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.MakeDao;
import garage.entities.Make;

@Repository
@Transactional
public class MakeDaoImpl implements MakeDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Returns all the Make objects in the database
	 * @return List<Make> of all makes.
	 */
	@Override
	public List<Make> getMakeData() {
		return em.createQuery("SELECT t FROM make t", Make.class)
				.getResultList();
	}
	
	/**
	 * Retrieves a single Make object.
	 * @param id
	 * @return a single make
	 */
	@Override
	public Make getMakeById(Integer makeId) {
		return em.createQuery("SELECT e FROM make e WHERE e.make_id = :id", Make.class)
				.setParameter("id", makeId)
				.getSingleResult();
	}
}
