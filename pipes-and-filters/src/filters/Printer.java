package filters;

import java.io.EOFException;

public class Printer extends Filter {
	public static final String OUTPUT_MESSAGE = "Output:";

	@Override
	public void execute() {
		// Read from input pipe while it is still open.
		while (true) {
			try {
				System.out.println(read());
			} catch (EOFException e) {
				// Input pipe is closed.
				break;
			}
		}
	}

}
