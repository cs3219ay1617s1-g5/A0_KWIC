package filters;

import java.io.EOFException;

public class Remover extends Filter {
	public static final String[] ignoredWords = { "is", "the", "of", "and", "as", "a", "after" };

	@Override
	public void execute() {
		// Read from input pipe while it is still open.
		while (true) {
			try {
				String input = read();
				
				// Write to output pipe if line is not ignored.
				if (!isLineIgnored(input)) {
					write(input);
				}
			} catch (EOFException e) {

				break;
			}
		}

		// Job done, close its output pipe.
		outputPipe.close();
	}
	
	/**
	 * Checks if the line starts with a non-keyword.
	 * @param input line to be checked.
	 * @return true if the line starts with a non-keyword.
	 */
	private boolean isLineIgnored(String input) {
		String[] words = input.split(" ");
		
		for (String ignoredWord : ignoredWords) {
			if (words[0].equalsIgnoreCase(ignoredWord)) {
				return true;
			}
		}
		
		return false;
	}
}
