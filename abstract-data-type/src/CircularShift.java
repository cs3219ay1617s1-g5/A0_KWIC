import java.util.*;

public class CircularShift {
	
	private LinkedList<String> tempString;
	
	public CircularShift() {
		tempString = new LinkedList<String>();
	}
	
	/*
	* Rotates each line and adds them to list of words 
	*/
	public void rotate(LineStorage lines) {
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
	public String arrToString(LinkedList<String> temp) {
		StringBuilder sb = new StringBuilder();
		for (String s : temp)
		{
		    sb.append(s);
		    sb.append(" ");
		}
		return sb.toString();
	}
}
