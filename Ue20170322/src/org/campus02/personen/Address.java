package org.campus02.personen;

public class Address implements Comparable<Address> {
	private String firstname;
	private String lastname;
	private String mobilNumber;
	private String email;
	
	public Address(String firstname, String lastname, String mobilNumber, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilNumber = mobilNumber;
		this.email = email;
	}
	
	public String toLine(String separator)
	{
		return firstname + separator + lastname + separator +
				mobilNumber + separator + email + separator;
	}

	@Override
	public String toString() {
		return "Address [firstname=" + firstname + ", lastname=" + lastname + ", mobilNumber=" + mobilNumber
				+ ", email=" + email + "]";
	}

	@Override
	public int compareTo(Address o) {
		int comp;
		
		if ((comp = this.lastname.compareTo(o.lastname)) != 0)
			return comp;
		if ((comp = this.firstname.compareTo(o.firstname)) != 0)
			return comp;	
		
		return this.mobilNumber.compareTo(o.mobilNumber);
	}
	
	
}
