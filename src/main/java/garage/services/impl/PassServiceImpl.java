package garage.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import garage.dao.PassDao;
import garage.entities.Pass;
import garage.services.InvalidInputException;
import garage.services.PassService;

@Service
public class PassServiceImpl implements PassService {

	@Autowired
	PassDao passDao;
	

	public void setPassDao(PassDao passDao) {
		this.passDao = passDao;
	}

	/**
	 * Retrieves all the Pass objects in the database.
	 * @return List<Pass> of all passes.
	 */
	@Override
	public List<Pass> getPassData() {
		List<Pass> pass = passDao.getPassData();
		List<Pass> allPass = new ArrayList<>();
		
		for (Pass e : pass) {
			allPass.add(e);
		}
		return allPass;
	}

	/**
	 * Retrieves a single Pass object located by the given id.
	 * @param id
	 * @return a single pass
	 */	
	@Override
	public Pass getPass(Integer passId) throws InvalidInputException {
		if (passId == null || passId < 0) {
			throw new InvalidInputException("passId.NullOrNegative");
		}
		return passDao.getPass(passId);
	}

	/**
	 * Adds a new Pass object that was created through the UI.
	 */
	@Override
	public void add(Pass pass) {
		if (pass == null) {
			throw new DataIntegrityViolationException("Pass number is null");
		}else{
			passDao.add(pass);
		}		
	}
	
	/**
	 * Updates a Pass object to the database that was changed through the UI.
	 * @param pass
	 * @return 
	 */
	@Override
	public void update(Pass pass) {
		if (pass == null) {
			throw new DataIntegrityViolationException("Pass number is null");
		}else{
			passDao.update(pass);
		}	
	}
	
	/**
	 * Deletes a Pass object from the database located by the given id.
	 */
	@Override
	public void delete(Integer passId) {
		passDao.delete(passId);
	}
	
}
