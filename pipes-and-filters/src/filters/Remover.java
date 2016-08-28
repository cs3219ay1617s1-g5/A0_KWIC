package filters;

import java.io.EOFException;
import java.util.ArrayList;

public class Remover extends Filter {
	private ArrayList<String> ignoredWords;
	
	public Remover() {
		ignoredWords = new ArrayList<String>();
	}
	
	/**
	 * Add a word to ignore as keyword into the ignoredWords list.
	 * @param word the word to ignore as keyword.
	 */
	public void addIgnoredWord(String word) {
		ignoredWords.add(word);
	}

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
