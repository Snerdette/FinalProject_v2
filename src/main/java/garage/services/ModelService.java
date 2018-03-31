package garage.services;

import java.util.List;

import garage.entities.Make;
import garage.entities.Model;

public interface ModelService {

	/**
	 * Returns a single Model object by id.
	 * @param id
	 * @return a single model.
	 */
	Model getModelById(Integer modelId) throws InvalidInputException;
	
	/**
	 * Returns all the Model objects in the database.
	 * @return List<Model> of all models.
	 */
	public List<Model> getModelData();
	
	/**
	 * Returns a List of all Model objects with the FK of the given makeId.
	 * @param makeId
	 * @return
	 * @throws InvalidInputException
	 */
	public List<Model> getModelsForMake(Integer makeId) throws InvalidInputException;

}
