import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedListRunner<E extends Comparable<E>> {

	public static ListNode<Integer> input() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter an Integer: ");
		Integer input = new Integer(in.readLine());
		return new ListNode<Integer>(input, null);
	}

	public static void add(LinkedListProgram<Integer> list) {
		try {
			list.add(input());
		} catch (Exception E) {
			System.out.println("Input error, try again");
		}
	}

	public static void delete(LinkedListProgram<Integer> list) {
		try {
			list.delete(input());
		} catch (Exception E) {
		}
	}

	public static void run(char input, LinkedListProgram<Integer> list) {
		switch (input) {
		case 'A':
			add(list);
			break;
		case 'D':
			delete(list);
			break;
		case 'C':
			list.deleteList();
			System.out.println("List Cleared");
			break;
		case 'P':
			list.printList();
			break;
		case 'R':
			list.reverseList(list.getFront());
			break;
		default:
			System.out.println("Invalid command, try again");
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		LinkedListProgram<Integer> list = new LinkedListProgram<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(
				"\nCommands: \nA: Add Node \nD: Delete Node \nC: Clear List \nP: Print List \nR: Reverse List \nQ: Quit");
		System.out.print("\nEnter a Command: ");
		char input = in.readLine().toUpperCase().charAt(0);
		while (input != 'Q') {
			run(input, list);
			System.out.print("\nEnter a Command:");
			input = in.readLine().toUpperCase().charAt(0);
		}
		System.out.println("Program Complete, Quitting");

	}

	// public static void mainOld() throws IOException {
	// GuestList list = new GuestList();
	// list.readFile();
	// list.insertionSort();
	// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	// System.out.println("\nCommands: \nG: Find a Guest\nL: List Guests\nN:
	// Number of Guests\nA: Add a Guest\nR: Change a Response\nC: Display a
	// Guest's Colleagues\nQ: Quit");
	// System.out.print("\nEnter a Command: ");
	// char input = in.readLine().toUpperCase().charAt(0);
	// while (input != 'Q') {
	// list.runStuff(input);
	// System.out.print("\nEnter a Command: ");
	// input = in.readLine().toUpperCase().charAt(0);
	// }
	// System.out.println("Program Complete, Quitting");
	// }
}