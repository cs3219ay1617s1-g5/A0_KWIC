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
	
	public void addTabooList(String newTabooWord){
		tabooWords.add(newTabooWord);
	}
	
	public int getLength() {
		return lines.size();
	}
	
	public String getLine(int position) {
		return lines.get(position);
	}
	
	public boolean isTaboo(String checkTabooWord) {
		for(String taboo : tabooWords) {
			if(checkTabooWord.equals(taboo)) {
				return true;
			}
		}
		return false;
	}
}
