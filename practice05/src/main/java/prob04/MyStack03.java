package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	public MyStack03(int capacity) {
		this.buffer = (T[])new Object[capacity];
	}

	public void push(T s) {
		if(top==buffer.length) resize();
		buffer[top++]=s;
	}

	public T pop() throws MyStackException {
		if(top==0) throw new MyStackException();
		return buffer[--top];
	}

	public boolean isEmpty() {
		if(top==0) return true;
		else return false;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		T[] newBuffer = (T[])new Object[buffer.length+1];
		System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);
		buffer = newBuffer;
	}	
}
