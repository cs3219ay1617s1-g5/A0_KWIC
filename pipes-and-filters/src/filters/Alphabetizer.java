package filters;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Filter {

	@Override
	public void execute() {
		ArrayList<String> lines = new ArrayList<String>();
		
		// Reads all the input, sort, and writes to the output pipe.
		readAll(lines);
		Collections.sort(lines);
		writeAll(lines);
		
		// Job done, close its output pipe.
		outputPipe.close();
	}

	/**
	 * Reads all the lines from the input pipe until it's closed.
	 * @param lines array list to add the lines read.
	 */
	private void readAll(ArrayList<String> lines) {
		// Read from input pipe while it is still open.
		while (true) {
			try {
				String input = read();
				input = capitalizeFirstLetter(input);
				lines.add(input);
			} catch (EOFException e) {
				// Input pipe is closed.
				break;
			}
		}
	}
	
	/**
	 * Make the first letter of a string to upper case.
	 * @param line the line to have its first letter made into upper case.
	 * @return the line with its first letter made into upper case.
	 */
	private String capitalizeFirstLetter(String line) {
		return line.substring(0, 1).toUpperCase() + line.substring(1);
	}
	
	/**
	 * Writes all the lines from an array list provided to the output pipe.
	 * @param lines array list of lines to write to the output pipe.
	 */
	private void writeAll(ArrayList<String> lines) {
		for (String line : lines) {
			write(line);
		}
	}
}
