package filters;

import java.io.EOFException;

public class Alphabetizer extends Filter {

	@Override
	public void execute() {
		while (true) {
			try {
				String input = read();
				System.out.println(input);
			} catch (EOFException e) {
				outputPipe.close();
				
				System.out.println("This is Alphabetizer");
			}
		}
	}

}
