package garage.dao;

import java.util.List;
import garage.entities.Pass;

public interface PassDao {

	/**
	 * Retrieves a List of all Pass objects in the database.
	 * @return List<Pass> all passes in database.
	 */
	public List<Pass> getPassData();

	/**
	 * Adds a new Pass object to the database.
	 * @param pass
	 */
	void add(Pass pass);
	
	/**
	 * Updates a Pass object.
	 * @param pass
	 */
	void update(Pass pass);
	
	/**
	 * Deletes a Pass object.
	 * @param pass
	 */
	void delete(Integer passId);
	
	/*void delete(Pass pass);*/

	/**
	 * Returns a single Pass objects located with the given id.
	 * @param passId
	 * @return
	 */
	public Pass getPass(Integer passId);
}
