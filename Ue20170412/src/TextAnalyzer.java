import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class TextAnalyzer {

	private ResultManager resultManager;
	private String path;
	
	public TextAnalyzer(ResultManager rm, String path) {
		this.resultManager = rm;
		this.path = path;
	}
	
	public void readReader()
	{
		try(BufferedReader br = new BufferedReader(
				new FileReader(path)))
		{
			String line;
			while ((line = br.readLine())!=null)
			{
				for(char c : line.toCharArray())
				{
					resultManager.addLetter(c);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readStream()
	{
		try(FileInputStream fis = new FileInputStream(path)) {
			
			int byteRead;
			while ((byteRead = fis.read()) != -1)
			{
				char c = (char) byteRead;
				if (Character.isDigit(c) || Character.isLetter(c))
					resultManager.addLetter(c);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
