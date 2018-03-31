package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.MakeDao;
import garage.entities.Make;
import garage.services.InvalidInputException;
import garage.services.MakeService;

@Service
public class MakeServiceImpl implements MakeService {

	@Autowired
	MakeDao makeDao;
	

	public void setMakeDao(MakeDao makeDao) {
		this.makeDao = makeDao;
	}

	/**
	 * Retrieves all the Make objects in the database.
	 * @return List<Make> of all makes.
	 */
	@Override
	public List<Make> getMakeData() {
		List<Make> make = makeDao.getMakeData();
		List<Make> allMake = new ArrayList<>();
		
		for (Make e : make) {
			allMake.add(e);
		}
		return allMake;
	}

	/**
	 * Retrieves a single Make object located by the given id.
	 * @param id
	 * @return a single make.
	 */	
	@Override
	public Make getMakeById(Integer makeId) throws InvalidInputException {
		if (makeId == null || makeId < 0) {
			throw new InvalidInputException("makeId.NullOrNegative");
		}
		return makeDao.getMakeById(makeId);
	}
}
