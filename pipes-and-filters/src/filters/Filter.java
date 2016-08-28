package filters;

import java.io.EOFException;

import pipes.Pipe;

public abstract class Filter implements Runnable {
	protected Pipe inputPipe;
	protected Pipe outputPipe;
	
	/**
	 * Sets the input pipe.
	 * @param inputPipe the input pipe of this filter.
	 */
	public void setInputPipe(Pipe inputPipe) {
		this.inputPipe = inputPipe;
	}
	
	/**
	 * Sets the output pipe.
	 * @param outputPipe the output pipe of this filter.
	 */
	public void setOutputPipe(Pipe outputPipe) {
		this.outputPipe = outputPipe;
	}
	
	/**
	 * Writes the processed results to the output pipe.
	 * @param results the processed results.
	 */
	public void write(String ... results) {
		for (String result : results) {
			outputPipe.write(result);
		}
	}
	
	/**
	 * Reads the results from the input pipe.
	 * @return the result from the input pipe.
	 */
	public String read() throws EOFException {
		return inputPipe.read();
	}
	
	@Override
	public void run() {
		execute();
	}
	
	/**
	 * Contains execution logic for subclasses that implements the Filter.
	 */
	public abstract void execute();
}
