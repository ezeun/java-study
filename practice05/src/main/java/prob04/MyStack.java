package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		this.buffer = new String[capacity];
	}

	public void push(String s) {
		if(top==buffer.length) resize();
		buffer[top++]=s;
	}

	public String pop() throws MyStackException {
		if(top==0) throw new MyStackException();
		return buffer[--top];
	}

	public boolean isEmpty() {
		if(top==0) return true;
		else return false;
	}

	private void resize() {
		String[] newBuffer = new String[buffer.length+1];
		System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
		buffer = newBuffer;
	}	
}