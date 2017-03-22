package org.campus02.personen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddressManager {
	private ArrayList<Address> addresses;
	
	
	
	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public AddressManager()
	{
		addresses = new ArrayList<>();
	}
	
	public void loadFromCsv(String path, String separator) 
			throws AddressLoadException, AddressLoadWrongFormatException
	{
		File f = new File(path);
		
		try (BufferedReader fb = new BufferedReader(
				new FileReader(f));){
				
			String line;
			while ((line = fb.readLine()) != null)
			{
				String[] columns =
						line.split(separator);
				
				if (columns.length != 4)
				{	
					throw new AddressLoadWrongFormatException(
							"Fehler bei Zeile: " + line);
				}
				Address a = new Address(columns[0], 
						columns[1], columns[2], columns[3]);
				
				add(a);
			}		
		} catch (FileNotFoundException e) {
			throw new AddressLoadException(e);
		} catch (IOException e) {
			throw new AddressLoadException(e);
		}		
	}
	
	public void exportToCsv(String path, String separator)
			throws AddressExportException, AddressExportFileAlreadyExistsException
	{
		File f = new File(path);
		if (f.exists())
			throw new AddressExportFileAlreadyExistsException();
		
		try (BufferedWriter pw = new 
				BufferedWriter(new FileWriter(f)))
		{
			for (Address address : addresses) {
				pw.write(address.toLine(separator));
				pw.newLine();
			}
			pw.flush();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generatete.printStackTrace();
			throw new AddressExportException(e);
		} catch (IOException e) {
			throw new AddressExportException(e);
		}
	}

	public void add(Address a) {
		addresses.add(a);	
	}
	
	public void printAll()
	{
		System.out.println("start printing ...");
		for (Address address : addresses) {
			System.out.println(address);
		}
		System.out.println("printing finished");
		System.out.println();
	}
}
