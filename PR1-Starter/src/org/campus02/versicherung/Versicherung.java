package org.campus02.versicherung;

import java.util.Arrays;

public class Versicherung {
	private int Id;
	private String[] versichertePersonen;
	private double versicherungsSumme;
	
	public Versicherung(int id, String[] versichertePersonen, double versicherungsSumme) {
		super();
		Id = id;
		this.versichertePersonen = versichertePersonen;
		this.versicherungsSumme = versicherungsSumme;
	}
	
	public void addVersichertePerson(String name)
	{
		String[] newArr = new String[versichertePersonen.length + 1];
		newArr[0] = name;
		
		for (int i = 0; i < versichertePersonen.length; i++) {
			newArr[i + 1] = versichertePersonen[i];
		}	
		versichertePersonen = newArr;
	}
	
	
	
	@Override
	public String toString() {
		return "Versicherung [Id=" + Id + ", versichertePersonen=" + Arrays.toString(versichertePersonen)
				+ ", versicherungsSumme=" + versicherungsSumme + "]";
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String[] getVersichertePersonen() {
		return versichertePersonen;
	}
	public void setVersichertePersonen(String[] versichertePersonen) {
		this.versichertePersonen = versichertePersonen;
	}
	public double getVersicherungsSumme() {
		return versicherungsSumme;
	}
	public void setVersicherungsSumme(double versicherungsSumme) {
		this.versicherungsSumme = versicherungsSumme;
	}
	
	
}
