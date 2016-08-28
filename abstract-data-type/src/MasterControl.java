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
		AlphabeticShift alphaShift = new AlphabeticShift();
		Output output = new Output();
		
		input.parse(sc, lines);
		shift.rotate(lines);
		alphaShift.execute(lines);
		output.print(lines);
	}
}