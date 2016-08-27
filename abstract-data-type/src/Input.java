import java.util.Scanner;

public class Input {	
	public Input() {
	}
	
	public void parse(Scanner sc, LineStorage lines) {
		System.out.println("Input: (Press 1 to finish input)");
		while(sc.hasNextLine()) {
			String nextTemp = sc.nextLine();
			if(nextTemp.equals("1")) 
				break;
			else 
				lines.addLine(nextTemp);
		}
		System.out.println("Words to ignore: ");
		while(sc.hasNextLine()) {
			String nextTemp = sc.nextLine();
			if(nextTemp.equals("1")) 
				break;
			else 
			lines.addTabooList(nextTemp);
		}	
	}
}
