package prob04;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	public MyStack02(int capacity) {
		this.buffer = new String[capacity];
	}

	public void push(Object s) {
		if(top==buffer.length) resize();
		buffer[top++]=s;
	}

	public Object pop() throws MyStackException {
		if(top==0) throw new MyStackException();
		return buffer[--top];
	}

	public boolean isEmpty() {
		if(top==0) return true;
		else return false;
	}

	private void resize() {
		Object[] newBuffer = new Object[buffer.length+1];
		System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
		buffer = newBuffer;
	}	
}
