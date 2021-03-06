
public class LinkedStack implements MyStack {
	
	private Node top;
	private int size;

	public LinkedStack() {
		top = null;
		size = 0;
	}
	
	@Override
	public boolean push(Integer data) {
		Node nn = new Node();
		nn.setData(data);
		nn.setNext(top);
		top = nn;
		size++;
		return true;
	}

	@Override
	public Integer pop() {
		if (isEmpty()) {
			return null;
		}
		
		Node rtn = top;
		top = top.getNext();
		size--;
		return rtn.getData();
	}
	
	public Integer readStack(int slot) {
		//Node rtn = top;
		//Node next = rtn.getNext();
		
		int rtn = 0;
		
		if (isEmpty()) {
			return -999;
		}
		
		Node n = top;
		
		int counter = -1;
		
		while (counter < slot) {
			if (n == null) {
				return -999;
			}
			rtn = n.getData();
			n = n.getNext();
			
			counter++;
		}

		return rtn;

		
	}

	@Override
	public boolean isEmpty() {

		return (size == 0);
	}

	@Override
	public Integer peek() {
		if (isEmpty()) {
			return null;
		}
		
		return top.getData();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void clear() {
		size = 0;
		top = null;
	}
	
	public String toString() {
		String rtn = "";
		
		if (isEmpty()) {
			return "<Empty>";
		}
		
		Node n = top;
		while (n != null) {
			if (n == top) {
				rtn += "top -> ";
			} else {
				rtn += "       ";
			}
			
			rtn += n.getData() + "\n";
			n = n.getNext();
		}
		
		return rtn;
	}

}
