import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientCommunication implements Runnable {

	Socket client;
	ResultManager rm;

	
	public ClientCommunication(Socket client, ResultManager rm) {
		super();
		this.client = client;
		this.rm = rm;
	}


	public  void processClient() {

		try(BufferedReader br = new BufferedReader(
				new InputStreamReader(client.getInputStream())
				);
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream())
						)
						
				){
			
			String cmd;
			
			while ((cmd = br.readLine()) != null)
			{
			//client sendet "analyze filename"
				String[] cmdparts = cmd.split(" ");
				if (cmdparts[0].equals("analyze"))
				{
					TextAnalyzer ta = new TextAnalyzer(rm, "D:\\PR2\\" 
										+ cmdparts[1]);
					ta.readStream();
					System.out.println("finisehd Analyze");
					rm.writeStream(client.getOutputStream());
					System.out.println("finished write");
				}
				else
				{	
					bw.write("wrong command, try again");
					bw.newLine();
					bw.flush();			
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void run() {
		processClient();
		
	}

}
