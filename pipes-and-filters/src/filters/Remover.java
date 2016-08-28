package filters;

import java.io.EOFException;

public class Remover extends Filter {
	public static final String[] ignoredWords = { "is", "the", "of", "and", "as", "a", "after" };

	@Override
	public void execute() {
		while (true) {
			try {
				String input = read();
				
				if (!isLineIgnored(input)) {
					write(input);
				}
			} catch (EOFException e) {
				outputPipe.close();
				System.out.println("This is Remover end");
				
				break;
			}
		}
	}
	
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
