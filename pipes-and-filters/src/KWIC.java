import java.util.ArrayList;
import filters.*;
import pipes.*;

public class KWIC {
	private ArrayList<Filter> filters;
	
	public KWIC() {
		filters = new ArrayList<Filter>();
		filters.add(new Reader());
		filters.add(new CircularShifter());
		filters.add(new Remover());
		filters.add(new Alphabetizer());
		filters.add(new Printer());
		
		// Setup the pipe between the filters.
		for (int i = 0; i < filters.size() - 1; i++) {
			Pipe pipe = new Pipe();
			
			filters.get(i).setOutputPipe(pipe);
			filters.get(i + 1).setInputPipe(pipe);
		}
	}
	
	/**
	 * Runs the filters in kwic.
	 */
	public void execute() {
		for (Filter filter: filters) {
			Thread thread = new Thread(filter);
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		KWIC kwic = new KWIC();
		kwic.execute();
	}
}
