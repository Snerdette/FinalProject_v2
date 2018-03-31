package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.PassDao;
import garage.entities.Pass;

@Repository
@Transactional
public class PassDaoImpl implements PassDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Returns all the Pass objects in the database
	 * @return List<Pass> of all passes.
	 */
	@Override
	public List<Pass> getPassData() {
		return em.createQuery("SELECT t FROM pass t", Pass.class)
				.getResultList();
	}
	
	/**
	 * Adds a new Pass object that was created through the UI.
	 * @param pass added to database
	 */
	@Override
	public void add(Pass pass) {
		em.persist(pass);
	}
	
	/**
	 * Updates a Pass object with changes sent from the UI.
	 * @param pass.
	 */
	@Override
	public void update(Pass pass) {
		em.merge(pass);
	}
	
	/**
	 * Retrieves a single Pass object.
	 * @param id
	 * @return a single pass
	 */
	@Override
	public Pass getPass(Integer passId) {
		return em.createQuery("SELECT e FROM pass e WHERE e.id = :id", Pass.class)
				.setParameter("id", passId)
				.getSingleResult();
	}

/*	@Override
	public void delete(Pass pass) {
		em.merge(pass);	
	}*/
	
	/**
	 * Deletes a Pass object from the database located with given id.
	 * @param id.
	 */
	@Override
	public void delete(Integer passId) {
		Pass pass = getPass(passId);
		em.remove(pass);
	}

}
