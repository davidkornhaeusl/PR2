package org.campus02.rekursion;

public class Demo {

	
	public static void main(String[] args) {
		
		Produkt p1 = new Produkt("Handy", 100);

		Produkt p2 = new Produkt("Display", 80);
		Produkt p3 = new Produkt("CPU", 20);
		Produkt p4 = new Produkt("Core1", 10);
		Produkt p5 = new Produkt("Core2", 10);
		
		p1.addProdukt(p2);
		p1.addProdukt(p3);
		p3.addProdukt(p4);
		p3.addProdukt(p5);
		
				
		
	}
	
}
