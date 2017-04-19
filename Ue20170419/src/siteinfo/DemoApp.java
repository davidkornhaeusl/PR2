package siteinfo;

import java.util.ArrayList;

public class DemoApp {

	
	
	public static void main(String[] args) {

		ArrayList<String> sites = new 
				ArrayList<>();
		
		sites.add("www.alibaba.com");
		sites.add("orf.at");
		sites.add("www.ask.com");
		sites.add("www.bbc.co.uk");
		sites.add("diepresse.com");
		
		ArrayList<Thread> threads = new ArrayList<>();
		ArrayList<HttpSiteInfo> httpSites = new ArrayList<>();
		
		for (String string : sites) {
			HttpSiteInfo hsi = new HttpSiteInfo(string);
			Thread th = new Thread(hsi);
			th.start();			
			threads.add(th);
			httpSites.add(hsi);
		}
		
		for (Thread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (HttpSiteInfo httpSiteInfo : httpSites) {
			System.out.println(httpSiteInfo.getPage());
		}

	}

}
