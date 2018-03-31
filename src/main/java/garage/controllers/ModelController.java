package garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garage.entities.Make;
import garage.entities.Model;
import garage.services.ModelService;
import garage.services.InvalidInputException;

@RestController
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	public void setModelService(ModelService modelService){
		this.modelService = modelService;
	}

	/**
	 * Retrieves all the Model objects in the database.
	 * @return List<Model> of all models.
	 */
	@RequestMapping(value="/model", method=RequestMethod.GET)
	public List<Model> getModelData(){
		return modelService.getModelData();
	}
	
	/**
	 * Retrieves the Model object located by the given id.
	 * @param id
	 * @return single model object.
	 * @throws InvalidInputException
	 */
	@RequestMapping(value="/model/{id}", method=RequestMethod.GET)
	public Model getModelById(@PathVariable Integer id)throws InvalidInputException{
		return modelService.getModelById(id);
	}
	
	/**
	 * Retrieves a List of all the Make objects for the given FK id.
	 * @param makeId
	 * @return List<Model> with the FK of the given makeId.
	 * @throws InvalidInputException
	 */
	@RequestMapping(value="/model/make_id/{makeId}", method=RequestMethod.GET)
	public List<Model> getModelsForMake(@PathVariable Integer makeId)throws InvalidInputException{
		return modelService.getModelsForMake(makeId);
	}

}
