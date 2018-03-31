package garage.services;

import java.util.List;

import garage.entities.Pass;

public interface PassService {

	/**
	 * Returns a single Pass object by id.
	 * @param id
	 * @return a single pass.
	 */
	Pass getPass(Integer passId) throws InvalidInputException;
	
	/**
	 * Returns all the passes in the database.
	 * @return List<pass> of all passes.
	 */
	public List<Pass> getPassData();
	
	/**
	 * Adds a new Pass object to the database.
	 * @param pass
	 * @throws Exception 
	 */
	public void add(Pass pass);
	
	/**
	 * Updates a Pass object in the database.
	 * @param pass
	 */
	public void update(Pass pass);
	
	/**
	 * Deletes Pass object from the database.
	 * @param passId
	 */
	public void delete(Integer passId);

}
