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
	
	
	public ArrayList<Produkt> findByMinPreis(int minPreis) {
		// Hier sollte Ihre Implementierung stehen
		return null; // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren
	}

	public ArrayList<Produkt> findExpensiveSubProjects() {
		// Hier sollte Ihre Implementierung stehen
		return null; // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren
	}
	
	
	
}
