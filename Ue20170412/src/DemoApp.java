
public class DemoApp {


	public static void main(String[] args) {
		ResultManager rm = new ResultManager("D:\\PR2\\letters.txt");
	
		rm.read();
		
		rm.addLetter('A');
		rm.addLetter('B');
		rm.addLetter('a');
		rm.addLetter('A');

		rm.write();
	}

}
