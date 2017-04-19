package siteinfo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.ArrayList;

public class HttpSiteInfo implements Runnable {

	private String domain;
	private ArrayList<String> page;
	
	public HttpSiteInfo(String domain) {
		this.domain = domain;
		page = new ArrayList<>();
	}
	
	
	public void work() {

		System.out.println(domain + " starting");

		try (Socket s = new Socket(domain, 80);
			BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
			BufferedReader br = new BufferedReader(
					new InputStreamReader(s.getInputStream()));		
				)
		{
			//sending a valid HTTP 1.1 GET request
			bw.write("GET / HTTP/1.1\r\nHost: " + domain + "\r\n\r\n");
			bw.flush();
						
			//open stream for reading
			
			//reading line by line and printing to console
			String line;
			while((line=br.readLine())!=null) {
				page.add(line);
			}
			System.out.println(domain + " finished");
			
			ArchiveSite as = new  ArchiveSite(page, domain + ".txt");
			as.write();
			System.out.println(domain + " archive finshed");
			
		}  catch (IOException e) {
			System.out.println("Fehler bei Domain: " + domain);
			e.printStackTrace();
		}

		
	}
	public String getDomain() {
		return domain;
	}
	public ArrayList<String> getPage() {
		return page;
	}


	@Override
	public void run() {
		work();		
	}
	
	
}
