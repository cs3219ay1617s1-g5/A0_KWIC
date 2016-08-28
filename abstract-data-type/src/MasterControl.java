import java.util.Scanner;

public class MasterControl {
	public static void main(String[] args) {	
		if(args.length != 2){
			System.err.println("Usage: Include filename");
			System.exit(1);
		}

		execute(args[0], args[1]);
	}
	
	public static void execute(String inputfile, String taboofile) {
		//Scanner sc = new Scanner(System.in);
		LineStorage lines = new LineStorage();
		Input input = new Input();
		CircularShift shift = new CircularShift();
		AlphabeticShift alphaShift = new AlphabeticShift();
		Output output = new Output();
		
		input.parse(inputfile, taboofile, lines);
		shift.rotate(lines);
		alphaShift.execute(lines);
		output.print(lines);
	}
}