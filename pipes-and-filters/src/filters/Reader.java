package filters;

import java.util.Scanner;

public class Reader extends Filter {
	private Scanner sc;
	
	public Reader() {
		sc = new Scanner(System.in);
	}

	@Override
	public void execute() {
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			
			if (input.equals("-1")) {
				break;
			}
			
			write(input);
		}
		
		outputPipe.close();
	}
}
