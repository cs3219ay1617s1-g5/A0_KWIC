package filters;

import java.util.Scanner;

public class Reader extends Filter {
	public static final String INSTRUCTION_MESSAGE = "Enter the line(s) that you which to be circularly shifted.\n"
												   + "Alternatively, enter -1 to end your input:";
	private Scanner sc;
	
	public Reader() {
		sc = new Scanner(System.in);
	}

	@Override
	public void execute() {
		System.out.println(INSTRUCTION_MESSAGE);
		
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
