public class Output {

	/*
	* Converts first char of keyword to UpperCase then
	* Prints list of rotated and sorted words
	*/
	public void print(AlphabeticShift shifter_) {
		for(int i=0 ; i<shifter_.getLength() ; i++) {
			shifter_.firstCharUpperCase(i);
			System.out.println(shifter_.getLine(i));
		}
	}
}