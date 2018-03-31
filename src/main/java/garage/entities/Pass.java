package garage.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name="pass")
public class Pass {

	/**
	 * Generates the id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pass_id")
	public  Integer id;
	
	/*@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")*/
	/**
	 * Required to have a expDate, formatting should match MM/DD/YYYY.
	 */
	@NotNull
	@Column(name="exp_date")
	private String expDate;
	
	/**
	 * Required to have a price, formatting should allow 2 decimals.
	 */
	@NotNull
	@Column(name="price")
	private double price;
	
	/**
	 * Joins the Pass table with the Customer table via customer_id.
	 */
	@NotNull
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn(name="customer_id")
	public Customer customer;
	
	/**
	 * Joins the Pass table with the Vehicle table via vehicle_id.
	 */
	@NotNull
	@OneToOne
	@JoinColumn(name="vehicle_id")
	public Vehicle vehicle;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
