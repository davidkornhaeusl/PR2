package org.campus02.rekursion;

import java.util.ArrayList;

public class Produkt {

	private String name;
	private int preis;
	
	private ArrayList<Produkt> produkte;
	
	public Produkt(String name, int preis) {
		super();
		this.name = name;
		this.preis = preis;
		
		this.produkte = new ArrayList<Produkt>();
	}
	
	public void addProdukt(Produkt produkt) {
		this.produkte.add(produkt);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Produkt [name=" + name + ", preis=" + preis + ", produkte=" + produkte + "]";
	}

	public ArrayList<Produkt> findByMinPreis(int minPreis) {
		// Hier sollte Ihre Implementierung stehen
		ArrayList<Produkt> retValue = new ArrayList<>();
		
		if (preis >= minPreis)
			retValue.add(this);
		
		for (Produkt produkt : produkte) {
			retValue.addAll(produkt.findByMinPreis(minPreis));
		}
		
		
		return retValue; // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren
	}

	public ArrayList<Produkt> findExpensiveSubProjects() {
		// Hier sollte Ihre Implementierung stehen
		
		return this.findExpensiveSubProjects(preis * 2); // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren
	}
	
	private ArrayList<Produkt> findExpensiveSubProjects
			(int prevPreis) {
		ArrayList<Produkt> retValue = new ArrayList<>();

		if (this.preis > prevPreis * 0.7)
			retValue.add(this);
		
		for (Produkt produkt : produkte) {
			retValue.addAll(
					produkt.findExpensiveSubProjects(preis)
					);
		}
		
		return retValue;
	}
	
	public void printAll(String prefix)
	{
		System.out.println(prefix + "-" + name);
		
		for (Produkt produkt : produkte) {
			produkt.printAll(" " + prefix + "-"+ name);
		}
	}
}
