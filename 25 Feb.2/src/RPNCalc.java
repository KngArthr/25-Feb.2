import java.util.Scanner;

public class RPNCalc {

	public void doIt() {
		LinkedStack stack = new LinkedStack();

		boolean done = false;
		Scanner kbd = new Scanner(System.in);
		System.out.println("Welcome to the RPN Calculator");

		String cmd = "";
		Integer result;
		while(!done) {
			
			System.out.print("H- Help \n-> ");
			cmd = kbd.nextLine();
			
			switch(cmd.toUpperCase()) {
				case "H":
				case "?":
					System.out.println("HELP!");
				break;
				
				case "Q":
					done = true;
				break;
				
				case "=":
					System.out.println(stack.peek());
				break;
				
				case "C":
					stack.clear();
				break;
				
				case "+":
					if (stack.size() < 2) {
						System.out.println("Error: Insufficient arguments");
						break;
					} else {
						Integer a = stack.pop();
						Integer b = stack.pop();
						result = a + b;
						stack.push(result);
					}
					break;
				
				case "-":
					if (stack.size() < 2) {
						System.out.println("Error: Insufficient arguments");
						break;
					} else {
						Integer a = stack.pop();
						Integer b = stack.pop();
						result = b - a;
						stack.push(result);
					}
					break;
				
				case "*":
					if (stack.size() < 2) {
						System.out.println("Error: Insufficient arguments");
						break;
					} else {
						Integer a = stack.pop();
						Integer b = stack.pop();
						result = a * b;
						stack.push(result);
					}
					break;
				
				case "/":
					if (stack.size() < 2) {
						System.out.println("Error: Insufficient arguments");
						break;
					} else {
						if (stack.peek() == 0) {
							System.out.println("Error: Divide by 0");
							break;
						}
						Integer a = stack.pop();
						Integer b = stack.pop();
						result = b / a;
						stack.push(result);
					}
					break;
				
				default:
					try {
						Integer num = Integer.valueOf(cmd);
						System.out.println("Pushing " + num);
						stack.push(num);
					} catch (NumberFormatException e) {
						System.out.println("Invalid Command (" + cmd + ")");
					}
					break;
			}
		}
	}
}
