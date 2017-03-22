package org.campus02.personen;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DemoApp {

	public static void main(String[] args) {

		Address a1 = new Address("Max", "Muster", "06641234567", "max.muster@test.com");
		
		AddressManager am = new AddressManager();
		try {
			am.loadFromCsv("D:\\PR2\\addresses.csv", ";");
		
			am.printAll();
			
			am.add(a1);
			
			am.printAll();
			
			am.exportToCsv("D:\\PR2\\addresses2.txt", ",");
			
		
		} catch (AddressLoadException | AddressLoadWrongFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressExportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressExportFileAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		am.printAll();
		
		Collections.sort( am.getAddresses());

		am.printAll();
	}

}
