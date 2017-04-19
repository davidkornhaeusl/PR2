package siteinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArchiveSite {
	private ArrayList<String> page;
	private String filename;
	public ArchiveSite(ArrayList<String> page, String filename) {
		super();
		this.page = page;
		this.filename = filename;
	}
	
	
	public void write()
	{
		try(PrintWriter pw = new PrintWriter(new File("D:\\PR2\\archive\\" + filename)))
		{
			for (String string : page) {
				pw.println(string);
			}
			pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
