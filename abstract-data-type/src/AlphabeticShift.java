public class AlphabeticShift {
	public AlphabeticShift() {
	}
	
	public void execute(LineStorage lines) {
		removeTabooStrings(lines);
		lines.sortArray();
	}

	public void removeTabooStrings(LineStorage lines) {
		for(int i=0 ; i<lines.getLength() ; i++) {
			if(lines.firstWordIsTaboo(i)) {
				lines.removeLine(i);
			}
		}
	}
}
