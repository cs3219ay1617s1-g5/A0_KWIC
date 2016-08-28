import java.util.*;

public class LineStorage {
	private ArrayList<String> lines;
	private ArrayList<String> tabooWords;
	
	public LineStorage() {
		lines = new ArrayList<>();
		tabooWords = new ArrayList<>();
	}
	
	public void addLine(String newString){
		lines.add(newString);
	}

	public void removeLine(int position) {
		lines.remove(position);
	}
	
	public void addTabooLine(String newTabooWord){
		tabooWords.add(newTabooWord);
	}
	
	public int getLength() {
		return lines.size();
	}
	
	public String getLine(int position) {
		return lines.get(position);
	}

	public boolean firstWordIsTaboo(int position) {
		for(String taboo : tabooWords) {
			if(taboo.toLowerCase().equals(lines.get(position).split(" ")[0].toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public void firstCharUpperCase(int position) {
		String temp = lines.get(position);
		String firstChar = temp.substring(0, 1).toUpperCase();
		lines.set(position, firstChar + temp.substring(1));
	}

	public void sortArray() {
		Collections.sort(lines);
	}
}
