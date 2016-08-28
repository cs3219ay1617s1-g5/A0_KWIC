public class Output {

	/*
	* Converts first char of keyword to UpperCase then
	* Prints list of rotated and sorted words
	*/
	public void print(LineStorage lines) {
		for(int i=0 ; i<lines.getLength() ; i++) {
			lines.firstCharUpperCase(i);
			System.out.println(lines.getLine(i));
		}
	}
}