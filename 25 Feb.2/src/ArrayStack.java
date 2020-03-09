
public class ArrayStack implements MyStack {
	
	public static final int STACK_SIZE = 2;
	public static final int GROWTH_INCREMENT = 20;
	private Integer []stack = new Integer[STACK_SIZE];
	private int nextLoc = 0;
	
	@Override
	public boolean push(Integer data) {
		if (isFull()) {
			// Make the stack bigger
			Integer []newStack = new Integer[stack.length + GROWTH_INCREMENT];
			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
			System.out.println("New Stack size is " + stack.length);
		}
		
		stack[nextLoc++] = data;
		return true;
	}
	
	@Override
	public Integer pop() {
		if (isEmpty()) {
			return null;
		}
		
		return stack[--nextLoc];
	}
	
	public void trimToSize() {
		Integer []newStack = new Integer[size()];
		
		for (int i = 0; i < size(); i++) {
			newStack[i] = stack[i];
		}
		
		stack = newStack;
	}
	
	@Override
	public boolean isEmpty() {
		return (nextLoc == 0);
	}
	
	@Override
	public boolean isFull() {
		return (nextLoc == stack.length);
	}
	
	@Override
	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		
		return stack[nextLoc-1];
	}
	
	@Override
	public int size() {
		return nextLoc;
	}
	
	public String toString() {
		String rtn = "";
		if (isEmpty()) {
			return "<Empty>";
		}
		
		for (int i = nextLoc-1; i >= 0; i--) {
			if (i == nextLoc-1) {
				rtn += "top -> ";
			} else {
				rtn += "       ";
			}
			
			rtn += stack[i] + "\n";
		}
		
		return rtn;
	}

}
