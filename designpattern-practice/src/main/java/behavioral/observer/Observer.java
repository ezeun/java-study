package behavioral.observer;

public interface Observer<T> { //Subject의 상태를 관찰 
	void update(T val);
}
