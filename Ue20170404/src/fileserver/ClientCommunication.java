package fileserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientCommunication {

	private Socket so = null;
	private String path1 = "D:\\PR2\\";

	public ClientCommunication(Socket so) {
		super();
		this.so = so;
	}

	public void runAll() {
		try (BufferedReader br = 
				new BufferedReader
					(new InputStreamReader(so.getInputStream()));
				BufferedWriter bw = 
						new BufferedWriter
							(new OutputStreamWriter(so.getOutputStream()))) {

			System.out.println("client connected..");

			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals("dir")) {
					bw.write(performDir());
					bw.newLine();
					bw.flush();
				} else if (line.startsWith("cat")) {
					String[] ar = line.split(" ");
					// [0] = "cat"
					// [1] = filename
					if (ar.length == 2) {
						LocalFileReader lfr = 
								new LocalFileReader
									(path1 + ar[1]);
						
						for(String fileLines : lfr.readFile2())
						{
							bw.write(fileLines);
							bw.newLine();
						}
						bw.flush();
					}
				} else if (line.equals("get")) {

				} else if (line.equals("quit")) {
					System.out.println("Server down");
					break;
				} else {
					bw.write("wrong command..  server is waiting again");
					bw.newLine();
					bw.flush();
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String performDir() {
		String ret = "reading path.. \n";
		
		File f = new File(path1);
		for (File st : f.listFiles()) {
			ret += st.getName() + " [" + st.length() + "] \n\r";
		}
		return ret;
	}

}
