import java.util.*;

public class CircularShift {

	private LinkedList<String> tempString;
	private LineStorage lines; 
	
	public CircularShift() {
		tempString = new LinkedList<String>();
	}

	/*
	* Rotates each line and adds them to list of words 
	*/
	public void rotate(LineStorage lines) {
		this.lines = lines;
		int oriListLength = lines.getLength();
		
		for(int i=0 ; i<oriListLength ; i++) {
			tempString = new LinkedList<>(Arrays.asList(lines.getLine(i).split(" ")));

			for(int k=0 ; k<tempString.size()-1 ; k++) {
				tempString.addFirst(tempString.removeLast());
				lines.addLine(arrToString(tempString));
			}
		}
	}
	
	/*
	* Converts LinkedList to String
	*/
	private String arrToString(LinkedList<String> temp) {
		StringBuilder sb = new StringBuilder();
		for (String s : temp)
		{
		    sb.append(s);
		    sb.append(" ");
		}
		return sb.toString();
	}

	public int getLength() {
		return lines.getLength();
	}

	public String getLine(int position) {
		return lines.getLine(position);
	}

	public void firstCharUpperCase(int position) {
		lines.firstCharUpperCase(position);
	}

	public boolean firstWordIsTaboo(int position) {
		return lines.firstWordIsTaboo(position);
	}

	public void removeLine(int position) {
		lines.removeLine(position);
	}

	public void sort() {
		lines.sortArray();
	}
}
