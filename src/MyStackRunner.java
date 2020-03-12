import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyStackRunner {

	public static void readFile(MyLinkedStack<String> stack) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter relative path of file: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("\nReading File...\n");
		String input = inFile.readLine();
		while (input != null) {
			run(input, stack);
			input = inFile.readLine();
		}
		System.out.println("Reading Complete.\n");
		inFile.close();
	}

	public static void run(String input, MyLinkedStack<String> stack) {
		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if (Character.isDigit(current)) {
				stack.push(Character.toString(current));
			} else {
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				try {
					if (current == '+') {
						stack.push(Integer.toString(a + b));
					} else if (current == '-') {
						stack.push(Integer.toString(a - b));
					} else if (current == '*') {
						stack.push(Integer.toString(a * b));
					} else if (current == '/') {
						stack.push(Integer.toString(a / b));
					}
				} catch (Exception ArithmeticException) {
					System.out.println("Arithmetic error, try again");
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		MyLinkedStack<String> stack = new MyLinkedStack<String>();
		readFile(stack);
		try {
			System.out.println("Result: " + stack.peek());
		} catch (Exception EmptyStackException) {
			System.out.println("Empty Stack,  input error");
		}
	}

}
