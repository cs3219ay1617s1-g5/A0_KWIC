public class Output {
	public Output() {
	}

	public void print(LineStorage lines) {
		for(int i=0 ; i<lines.getLength() ; i++) {
			//make starting letter in uppercase 
			lines.firstCharUpperCase(i);
			System.out.println(lines.getLine(i));
		}
	}
}