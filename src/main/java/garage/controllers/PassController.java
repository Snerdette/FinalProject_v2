package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Pass;
import garage.services.InvalidInputException;
import garage.services.PassService;

@RestController
public class PassController {

	@Autowired
	private PassService passService;
	
	public void setPassService(PassService passService){
		this.passService = passService;
	}
	
	/**
	 * Retrieves a list of all the Pass objects in the database.
	 * @return List<Pass> of all passes.
	 */
	@RequestMapping(value="/pass", method=RequestMethod.GET)
	public List<Pass> getPassData(){
		return passService.getPassData();
	}
	
	/**
	 * Retrieves a single Pass located by the given id.
	 * @param id
	 * @return a single pass.
	 * @throws InvalidInputException
	 */
	@RequestMapping(value="/pass/{id}", method=RequestMethod.GET)
	public Pass getPassById(@PathVariable Integer id)throws InvalidInputException{
		return passService.getPass(id);
	}
	
	/**
	 * Places a new Pass object into the database.
	 * @param pass
	 */
	@RequestMapping(value="/pass", method=RequestMethod.POST)  
	public void addPass(@RequestBody Pass pass) { 
		System.out.println(pass);
		passService.add(pass);
	}
	
	/**
	 * Returns a single Pass object located by the given id.
	 * @param id
	 * @param pass
	 */
	@RequestMapping(value="/pass/{id}", method=RequestMethod.PUT)
	public void updatePass(@PathVariable Integer id, @RequestBody Pass pass){ 
		pass.setId(id);
		passService.update(pass);
	}
	
	/**
	 * Removes a Pass object located by the given id.
	 * @param id
	 */
	@RequestMapping(value="/pass/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable Integer id){
		passService.delete(id);
	}
}
