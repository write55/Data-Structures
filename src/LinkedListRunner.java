import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			System.out.println("Input error, try again");
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

	public static char getInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter a Command: ");
		String input = in.readLine().toUpperCase();
		while (input.isEmpty()) {
			System.out.println("Nothing entered, try again");
			System.out.print("\nEnter a Command: ");
			input = in.readLine().toUpperCase();
		}
		return input.charAt(0);
	}

	public static void main(String[] args) throws IOException {
		LinkedListProgram<Integer> list = new LinkedListProgram<>();
		System.out.println(
				"\nCommands: \nA: Add Node \nD: Delete Node \nC: Clear List \nP: Print List \nR: Reverse List \nQ: Quit");
		char input = getInput();
		while (input != 'Q') {
			run(input, list);
			input = getInput();
		}
		System.out.println("Program Complete, Quitting");

	}

}


//RUN 1

/*

Commands: 
A: Add Node 
D: Delete Node 
C: Clear List 
P: Print List 
R: Reverse List 
Q: Quit

Enter a Command: A
Enter an Integer: 15

Enter a Command:A
Enter an Integer: 10

Enter a Command:A
Enter an Integer: 25

Enter a Command:D
Enter an Integer: 12
Not on List

Enter a Command:A
Enter an Integer: one
Input error, try again

Enter a Command:A
Enter an Integer: 5

Enter a Command:A
Enter an Integer: 20

Enter a Command:A
Enter an Integer: 15
Already on List

Enter a Command:D
Enter an Integer: 30
Not on List

Enter a Command:A
Enter an Integer: 17

Enter a Command:A
Enter an Integer: 16

Enter a Command:A
Enter an Integer: 10
Already on List

Enter a Command:D
Enter an Integer: 15
Input error, try again

Enter a Command:D
Enter an Integer: x

Enter a Command:D
Enter an Integer: 10

Enter a Command:P
[ 5 16 17 20 25 ]

Enter a Command:A
Enter an Integer: 4

Enter a Command:A
Enter an Integer: 0

Enter a Command:D
Enter an Integer: 25

Enter a Command:D
Enter an Integer: 20

Enter a Command:D
Enter an Integer: -4
Not on List

Enter a Command:A
Enter an Integer: 18

Enter a Command:A
Enter an Integer: 5
Already on List

Enter a Command:A
Enter an Integer: 19

Enter a Command:D
Enter an Integer: 0

Enter a Command:D
Enter an Integer: 4

Enter a Command:P
[ 5 16 17 18 19 ]

Enter a Command:C
List Cleared

Enter a Command:P
List is Empty

Enter a Command:D
Enter an Integer: 10
List Empty

Enter a Command:A
Enter an Integer: 5

Enter a Command:A
Enter an Integer: 10

Enter a Command:A
Enter an Integer: 7

Enter a Command:P
[ 5 7 10 ]

Enter a Command:Q
Program Complete, Quitting

*/

//RUN 2

/*

Commands: 
A: Add Node 
D: Delete Node 
C: Clear List 
P: Print List 
R: Reverse List 
Q: Quit

Enter a Command: A
Enter an Integer: 5

Enter a Command:D
Enter an Integer: 5

Enter a Command:P
List is Empty

Enter a Command:Q
Program Complete, Quitting

*/
