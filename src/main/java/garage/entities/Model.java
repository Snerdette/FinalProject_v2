package garage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="model")
public class Model {

	/**
	 * Generates the id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	public  Integer id;
	
	/**
	 * Joins the Model table with the Make table via make_id.
	 */
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="make_id")
	public Make make;
	
	/**
	 * Required field to add name.
	 */
	@NotNull
	@Column(name="name")
	public String name;

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

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}
	
}
