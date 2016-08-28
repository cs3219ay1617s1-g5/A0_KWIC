import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Input {
	
	public void parse(String inputfile, String taboofile, LineStorage lines) {
		parseFiles(inputfile, true, lines);
		parseFiles(taboofile, false, lines);
	}

	/*
	* Reads input from file and saves them to respective ArrayLists
	* .addLine() method saves string to input list
	* .addTabooLine() method saves string to 'words to ignore' list 
	*/
	public void parseFiles(String filename, boolean isInput, LineStorage lines) {
		try {
			BufferedReader breader = new BufferedReader(new FileReader(filename));
			String lineToAdd = breader.readLine();

			while(lineToAdd != null && !lineToAdd.isEmpty()) {
				if(isInput) 
					lines.addLine(lineToAdd);
				else 
					lines.addTabooLine(lineToAdd);
				lineToAdd = breader.readLine();
			}
			
		} catch(FileNotFoundException exc){
			exc.printStackTrace();
			System.err.println("KWIC Error: Could not open " + filename + "file.");
			System.exit(1);
		} catch(IOException exc){
			exc.printStackTrace();
			System.err.println("KWIC Error: Could not read " + filename + "file.");
			System.exit(1);
		}
	}
}
