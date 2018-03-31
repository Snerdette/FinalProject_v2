package garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="vehicle")
public class Vehicle {
	
	/**
	 * Generates the id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*@Column(name="vehicle_id")*/
	public  Integer id;
	
	/**
	 * Joins the Vehicle table with the Model table via model_id.
	 */
	@ManyToOne
	@JoinColumn(name="model_id")
	public Model model;
	
	/**
	 * Required field to add year.
	 */
	@Column(name="year", length=4)
	public int year;
	
	/**
	 * Required field to add color.
	 */
	@Column(name="color")
	private String color;
	
	/**
	 * Required field to add plateNumber.
	 */
	@Column(name="plate_number")
	private String plateNumber;
	
	/**
	 * Required field to add plateState.
	 */
	@Column(name="plate_state")
	private String plateState;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateState() {
		return plateState;
	}

	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
