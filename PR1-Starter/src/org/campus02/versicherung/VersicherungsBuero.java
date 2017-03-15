package org.campus02.versicherung;

import java.util.ArrayList;
import java.util.HashMap;

public class VersicherungsBuero {

	private ArrayList<Versicherung> versicherungen;
	
	public VersicherungsBuero()
	{
		versicherungen = new ArrayList<>();
	}
	
	
	
	public ArrayList<Versicherung> getVersicherungen() {
		return versicherungen;
	}



	public void setVersicherungen(ArrayList<Versicherung> versicherungen) {
		this.versicherungen = versicherungen;
	}



	public void add(Versicherung v)
	{
		versicherungen.add(v);
	}
	
	public ArrayList<String> findVersichertePersonen
		(double von, double bis)
	{
		ArrayList<String> returnList = new ArrayList<>();
		
		for (Versicherung v : versicherungen) {
			if (v.getVersicherungsSumme() >= von
					&& v.getVersicherungsSumme() <= bis
					)
			{
				String[] arr = v.getVersichertePersonen();
				for (String person : arr) {
					if (!returnList.contains(person))
						returnList.add(person);
				}
			}
				
		}
		
		return returnList;
	}
	
	public HashMap<String, Integer> countByVersichertePerson()
	{
		HashMap<String, Integer> result = new HashMap<>();
		for (Versicherung versicherung : versicherungen) {
			for (String person: versicherung.getVersichertePersonen()) {
				int counter = 1;
				if (result.containsKey(person))
				{
					// person existiert schon
					counter = result.get(person) + 1;
				}
				result.put(person, counter);
			}
		}
		return result;
	}
	
	public HashMap<String, Double> sumByPerson()
	{
		HashMap<String, Double> result = new HashMap<>();
		for (Versicherung versicherung : versicherungen) {
			for (String person: versicherung.getVersichertePersonen()) {
				double value = versicherung.getVersicherungsSumme();
				if (result.containsKey(person))
				{
					// person existiert schon
					value += result.get(person);
				}
				result.put(person, value);
			}
		}
		return result;
	}
	
	public HashMap<String, Double> maxByPerson()
	{
		HashMap<String, Double> result = new HashMap<>();
		for (Versicherung versicherung : versicherungen) {
			for (String person: versicherung.getVersichertePersonen()) {
				// CODE
				if (!result.containsKey(person))
				{ 	// Kunde noch nicht in Map ... 
					result.put(person, versicherung.getVersicherungsSumme());
				}
				else
				{
					// Person bereits mit einem Wert in HashMap
					double comp = versicherung.getVersicherungsSumme();
					double currentMax = result.get(person);
					
					if (comp > currentMax)
					{
						result.put(person, comp);
					}
				}
			}
		}
		return result;
	}
}
