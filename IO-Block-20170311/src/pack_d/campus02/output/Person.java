package pack_d.campus02.output;

import java.io.Serializable;

public class Person implements Serializable {
	private String firstname;
	private String lastname;
	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
	
	
}
