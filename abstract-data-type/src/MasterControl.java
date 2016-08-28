public class MasterControl {	

	public void execute(String inputfile, String taboofile) {
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

	public static void main(String[] args) {	
		if(args.length != 2){
			System.err.println("Usage: java MasterControl (filename) (words to ignore filename)");
			System.exit(1);
		}

		MasterControl control = new MasterControl();
		control.execute(args[0], args[1]);
	}
}