package garage.services;

import java.util.List;

import garage.entities.Make;

public interface MakeService {

	/**
	 * Returns a single Make object by id.
	 * @param id
	 * @return a single make.
	 */
	Make getMakeById(Integer makeId) throws InvalidInputException;
	
	/**
	 * Returns all the Makes in the database.
	 * @return List<Make> of all makes.
	 */
	public List<Make> getMakeData();
	
}
