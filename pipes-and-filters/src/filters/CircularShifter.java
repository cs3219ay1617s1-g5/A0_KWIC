package filters;

import java.io.EOFException;
import java.util.ArrayList;

public class CircularShifter extends Filter {

	@Override
	public void execute() {
		// Read from input pipe while it is still open.
		while (true) {
			try {
				String input = read();
				String[] shiftedInputs = shift(input);
				
				write(shiftedInputs);
			} catch (EOFException e) {
				// Input pipe is closed.
				break;
			}
		}
		
		// Job done, close its output pipe.
		outputPipe.close();
	}
	
	/**
	 * Generates an array of strings that resulted from the shift.
	 * @param input the input to be shifted.
	 * @return an array of shifted string based on the input provided.
	 */
	private String[] shift(String input) {
		String[] words = input.split(" ");
		String[] shiftedInputs = new String[words.length];
		
		// Loop through different words in a line to use as keyword.
		for (int i = 0; i < words.length; i++) {
			String shiftedInput = buildLine(words, i);
			shiftedInputs[i] = shiftedInput;
		}
		
		return shiftedInputs;
	}

	/**
	 * Build the Line starting from the startIndex given circularly.
	 * @param words the words used to build the Line
	 * @param startIndex index to start building
	 * @return a line that is made up of the words starting from the index specified.
	 */
	private String buildLine(String[] words, int startIndex) {
		String shiftedInput = "";
		
		// Loop to form a line starting from the start index to start index - 1 (circular)
		for (int i = 0; i < words.length; i++) {
			int index = (startIndex + i) % words.length;
			
			shiftedInput += words[index];
			shiftedInput += " ";
		}
		
		return shiftedInput.trim();
	}
}
