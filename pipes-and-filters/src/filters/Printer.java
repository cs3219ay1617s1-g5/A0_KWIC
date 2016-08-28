package filters;

import java.io.EOFException;

public class Printer extends Filter {

	@Override
	public void execute() {
		while (true) {
			try {
				System.out.println(read());
			} catch (EOFException e) {
				System.out.println("This is Printer");
				break;
			}
		}
	}

}
