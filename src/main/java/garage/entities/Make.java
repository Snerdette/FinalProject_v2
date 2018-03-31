package garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="make")
public class Make {
	
	/**
	 * Generates the id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="make_id")
	public  Integer id;
	
	/**
	 * Required field to add name.
	 */
	@NotNull
	@Column(name="name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}*/
	
}
