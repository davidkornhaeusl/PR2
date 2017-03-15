package org.campus02.versicherung;

public class Demo {

	public static void main(String[] args) {

		VersicherungsBuero vb = new VersicherungsBuero();
		vb.add(new Versicherung(1, new String[] {"Max", "Susi"}, 3000));
		vb.add(new Versicherung(1, new String[] {"John"}, 2600));
		vb.add(new Versicherung(1, new String[] {"Gregor", "Sandy"}, 2000));
		vb.add(new Versicherung(1, new String[] {"Franz", "Andreas", "Hans"}, 1000));

	
		for (String person : vb.findVersichertePersonen(1999, 1900)) {
			System.out.println(person);
		}
		
		System.out.println("-------------------");
		
		System.out.println(vb.countByVersichertePerson());
	}

}
