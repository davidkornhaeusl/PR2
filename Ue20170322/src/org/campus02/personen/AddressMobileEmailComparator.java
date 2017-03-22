package org.campus02.personen;

import java.util.Comparator;

public class AddressMobileEmailComparator implements Comparator<Address> {

	public AddressMobileEmailComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Address arg0, Address arg1) {
		// TODO Auto-generated method stub
		int comp;
		if ((comp = arg0.getMobilNumber()
				.compareTo(arg1.getMobilNumber()))!= 0)
				return comp;
		if ((comp = arg0.getEmail()
				.compareTo(arg1.getEmail()))!= 0)
				return comp;
		return 0;
	}

}
