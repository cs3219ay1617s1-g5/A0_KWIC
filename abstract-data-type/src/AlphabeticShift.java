public class AlphabeticShift {
	
	/*
	* Removes line if necessary and then sorts list
	*/
	public void execute(LineStorage lines) {
		removeTabooStrings(lines);
		lines.sortArray();
	}

	/*
	* Checks and removes line from list if first word is in 'words to ignore' list
	*/
	public void removeTabooStrings(LineStorage lines) {
		for(int i=0 ; i<lines.getLength() ; i++) {
			if(lines.firstWordIsTaboo(i)) {
				lines.removeLine(i);
			}
		}
	}
}
