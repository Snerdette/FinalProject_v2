package garage.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="customer")
public class Customer {
	
	/**
	 * Generates the id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	public  Integer id;
	
	/**
	 * Required field to add firstName.
	 */
	@NotNull
	@Column(name="first_name")
	public String firstName;
	
	/**
	 * Required field to add lastName.
	 */
	@NotNull
	@Column(name="last_name")
	public String lastName;
	
	/**
	 * Required field to add email.
	 */
	@NotNull
	@Column(name="email", unique=true)
	public String email;
	
	/**
	 * Required field to add phone max length of 10.
	 */
	@NotNull
	@Column(name="phone", length=10)
	public String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
