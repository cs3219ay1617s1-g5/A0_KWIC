import java.util.ArrayList;
import java.util.Scanner;

import filters.*;
import pipes.*;

public class KWIC {
	public static final int READER_PIPE_INDEX = 0;
	public static final int REMOVER_PIPE_INDEX = 2;
	public static final String IGNORE_WORD_MESSAGE = "Enter word(s) to ignore as keyword. Enter -1 to skip / end:";
	
	private ArrayList<Filter> filters;
	private Scanner sc;
	
	public KWIC() {
		sc = new Scanner(System.in);
		filters = new ArrayList<Filter>();
		
		filters.add(new Reader());
		filters.add(new CircularShifter());
		filters.add(new Remover());
		filters.add(new Alphabetizer());
		filters.add(new Printer());
		
		// Setup the pipe between the filters.
		for (int i = 0; i < filters.size() - 1; i++) {
			Pipe pipe = new Pipe();
			
			filters.get(i).setOutputPipe(pipe);
			filters.get(i + 1).setInputPipe(pipe);
		}
	}
	
	/**
	 * Runs the filters in kwic.
	 */
	public void execute() {
		setup();
		
		for (Filter filter: filters) {
			Thread thread = new Thread(filter);
			thread.start();
		}
	}
	
	/**
	 * To setup list of words to ignore.
	 */
	private void setup() {
		Remover remover = (Remover) filters.get(REMOVER_PIPE_INDEX);
		Reader reader = (Reader) filters.get(READER_PIPE_INDEX);
		
		reader.setScanner(sc);
		
		// Reads words to ignore.
		System.out.println(IGNORE_WORD_MESSAGE);
		while (sc.hasNext()) {
			String input = sc.next();
			
			if (input.equalsIgnoreCase("-1")) {
				break;
			}
			
			remover.addIgnoredWord(input);
		}
	}
	
	public static void main(String[] args) {
		KWIC kwic = new KWIC();
		kwic.execute();
	}
}
