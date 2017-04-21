package fileserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LocalFileReader {
	private String path = null;

	public LocalFileReader(String path) {
		super();
		this.path = path;
		// this.readFile = readFile;
	}

	public String readFile() {
		StringBuilder sb = new StringBuilder();
		File file = new File(path);

		if (!file.isFile()) {
			return "Das war keine Datei:" + path;
		}

		try (BufferedReader br = 
				new BufferedReader(
						new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}
	
	public ArrayList<String> readFile2() {
		ArrayList<String> arr = new ArrayList<>();
		File file = new File(path);

		if (!file.isFile()) {
			return null;
		}

		try (BufferedReader br = 
				new BufferedReader(
						new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				arr.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}
}
