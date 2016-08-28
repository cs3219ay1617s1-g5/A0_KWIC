package pipes;

import java.io.EOFException;
import java.util.ArrayList;

public class Pipe {
	private ArrayList<String> buffer;
	private boolean isClosed;
	
	public Pipe() {
		buffer = new ArrayList<String>();
		isClosed = false;
	}
	
	/**
	 * Writes the content to the pipe.
	 * @param content to be written.
	 */
	public void write(String content) {
		if (isClosed) {
			return;
		}
		
		buffer.add(content);
	}
	
	/**
	 * Reads the content from the pipe's buffer.
	 * @return a string if there's something in the buffer, otherwise
	 */
	public String read() throws EOFException {
		// Keeps reading until the pipe is closed and buffer is empty.
		while (true) {
			if (buffer.isEmpty()) {
				if (isClosed) {
					throw new EOFException();
				}

				// Nothing in pipe buffer and pipe is not closed.
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				return buffer.remove(0);
			}
		}
	}
	
	/**
	 * Close the pipe.
	 */
	public void close() {
		isClosed = true;
	}
}
