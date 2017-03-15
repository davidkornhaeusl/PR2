package org.campus02.rekursion;

public class Demo {

	
	public static void main(String[] args) {
		
		Produkt p1 = new Produkt("Handy", 100);

		Produkt p2 = new Produkt("Display", 82);
		Produkt p3 = new Produkt("CPU", 20);
		Produkt p4 = new Produkt("Core1", 10);
		Produkt p5 = new Produkt("Core2", 16);
		
		p1.addProdukt(p2);
		p1.addProdukt(p3);
		p3.addProdukt(p4);
		p3.addProdukt(p5);
		
		for (Produkt p : p1.findByMinPreis(15)) {
			System.out.println(p);
		}
		System.out.println("-------------");
		for (Produkt p : p1.findExpensiveSubProjects()) {
			System.out.println(p);
		}
		
		System.out.println("-----------------");
		p1.printAll("");
	}
	
}
