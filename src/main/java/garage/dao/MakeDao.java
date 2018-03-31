package garage.dao;

import java.util.List;
import garage.entities.Make;

public interface MakeDao {

	/**
	 * Returns a list of all Make objects in database
	 * @return List<Make> of all makes.
	 */
	public List<Make> getMakeData();
	
	/**
	 * Returns a single Make object located by the given id.
	 * @param makeId
	 * @return
	 */
	public Make getMakeById(Integer makeId);
}
