package garage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import garage.dao.ModelDao;
import garage.entities.Model;

@Repository
@Transactional
public class ModelDaoImpl implements ModelDao{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Returns all the Model objects in the database
	 * @return List<Model> of all models.
	 */
	@Override
	public List<Model> getModelData() {
		return em.createQuery("SELECT t FROM model t", Model.class)
				.getResultList();
	}
	
	/**
	 * Retrieves a single Model object.
	 * @param id
	 * @return a single model
	 */
	@Override
	public Model getModelById(Integer modelId) {
		return em.createQuery(("SELECT e FROM model e WHERE e.id = :id"), Model.class)
				.setParameter("id", modelId)
				.getSingleResult();
	}

	/**
	 * Returns all the Model objects in the database with the FK of makeId.
	 * @return List<Model> of all models with matching FK makeId.
	 */
	@Override
	public List<Model> getModelsForMake(Integer makeId) {
		return em.createQuery("SELECT mo FROM model mo WHERE mo.make.id = :id", Model.class)
				.setParameter("id", makeId)
				.getResultList();
	}

}
