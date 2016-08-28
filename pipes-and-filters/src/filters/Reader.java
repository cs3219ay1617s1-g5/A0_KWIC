package filters;

import java.util.Scanner;

public class Reader extends Filter {
	public static final String INSTRUCTION_MESSAGE = "Enter the line(s) that you which to be circularly shifted.\n"
												   + "Alternatively, enter -1 to end your input:";
	private Scanner sc;
	
	public void setScanner(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void execute() {
		System.out.println(INSTRUCTION_MESSAGE);
		
		// Read while there's still things to read.
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			
			if (input.equals("-1")) {
				break;
			}
			
			// Write to its output pipe.
			write(input);
		}
		
		// Job done, close its output pipe.
		outputPipe.close();
	}
}
