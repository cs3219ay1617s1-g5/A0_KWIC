import java.util.*;

public class CircularShift {
	private LinkedList<String> tempString;
	
	public CircularShift() {
		tempString = new LinkedList<String>();
	}
	
	public void rotate(LineStorage lines) {
		int oriListLength = lines.getLength();	//not sure if using lines.getLength directly 
												//cause length is always changing 
		
		for(int i=0 ; i<oriListLength ; i++) {
			tempString = new LinkedList<>(Arrays.asList(lines.getLine(i).split(" ")));
			for(int k=0 ; k<tempString.size()-1 ; k++) {
				tempString.addFirst(tempString.removeLast());
				if(!lines.isTaboo(tempString.getFirst())) {
					lines.addLine(arrToString(tempString));
				}
			}
		}
	}
	
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
