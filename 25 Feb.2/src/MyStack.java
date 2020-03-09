
public interface MyStack {

	boolean push(Integer data);

	Integer pop();

	boolean isEmpty();

	default boolean isFull() {
		return false;
	}

	Integer peek();

	int size();

}