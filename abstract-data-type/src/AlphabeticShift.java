import java.util.*;

public class AlphabeticShift {

	 private CircularShift cshifter_;

	/*
	* Removes line if necessary and then sorts list
	*/
	public void execute(CircularShift shifter) {
		cshifter_ = shifter;
		removeTabooStrings();
		cshifter_.sort();
	}

	/*
	* Checks and removes line from list if first word is in 'words to ignore' list
	*/
	private void removeTabooStrings() {
		for(int i=0 ; i<cshifter_.getLength() ; i++) {
			if(cshifter_.firstWordIsTaboo(i)) {
				cshifter_.removeLine(i);
			}
		}
	}

	public int getLength() {
		return cshifter_.getLength();
	}

	public void firstCharUpperCase(int position) {
		cshifter_.firstCharUpperCase(position);
	}

	public String getLine(int position) {
		return cshifter_.getLine(position);
	}
}
