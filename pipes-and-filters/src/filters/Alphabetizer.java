package filters;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Filter {

	@Override
	public void execute() {
		ArrayList<String> lines = new ArrayList<String>();
		
		readAll(lines);
		Collections.sort(lines);
		writeAll(lines);
		
		outputPipe.close();
		System.out.println("This is Alphabetizer end");
	}

	private void readAll(ArrayList<String> lines) {
		while (true) {
			try {
				String input = read();
				lines.add(input);
			} catch (EOFException e) {
				break;
			}
		}
	}
	
	private void writeAll(ArrayList<String> lines) {
		for (String line : lines) {
			write(line);
		}
	}
}
