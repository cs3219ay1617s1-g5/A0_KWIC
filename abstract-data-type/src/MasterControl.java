import java.util.Scanner;

public class MasterControl {
	public static void main(String[] args) {		
		execute();
	}
	
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		LineStorage lines = new LineStorage();
		Input input = new Input();
		CircularShift shift = new CircularShift();
		
		input.parse(sc, lines);
		shift.rotate(lines);
		print(lines);
	}
	
	public static void print(LineStorage lines) {
		for(int i=0 ; i<lines.getLength() ; i++) {
			System.out.println(lines.getLine(i));
		}
	}
}