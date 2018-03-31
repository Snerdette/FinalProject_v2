package garage.dao;

import java.util.List;
import garage.entities.Model;

public interface ModelDao {

	/**
	 * Returns a list of all Model objects in the database
	 * @return List<Model> all models.
	 */
	public List<Model> getModelData();

	/**
	 * Returns a single Model object located with the given id.
	 * @param modelId
	 * @return single model.
	 */
	public Model getModelById(Integer modelId);
	
	/**
	 * Returns a list of Model objects that have a FK of the given makeId.
	 * @param makeId
	 * @return List<Model> all models with given makeId.
	 */
	public List<Model> getModelsForMake(Integer makeId);
}
