package Domain;

public class CustomerDomain {

	int customerId;
	String firstName;
	String lastName;
	String address;
	int phone;

	
	public CustomerDomain(int customerId, String firstName, String lastName, String address, int phone) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}
	

	public CustomerDomain() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CustomerDomain [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", phone=" + phone + "]";
	}
	

}
