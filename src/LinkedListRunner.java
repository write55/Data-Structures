import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedListRunner<E extends Comparable<E>> {

    /**
     * Creates a new ListNode object with an Integer in the data field, taking
     * user input
     *
     * @return ListNode object with next = null and given Integer data
     * @throws NumberFormatException
     * @throws IOException
     */
    public static ListNode<Integer> input() throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter an Integer: ");
        Integer input = Integer.valueOf(in.readLine());
        // Integer input = new Integer(in.readLine());
        return new ListNode<Integer>(input, null, null);
    }

    /**
     * Calls the add method on a given LinkedListProgram object with a ListNode
     * object from input()
     *
     * @param list LinkedListProgram object, the given linked list which a new
     *             ListNode object is added to
     */
    public static void add(LinkedListProgram<Integer> list) {
        try {
            // list.add(input());
        } catch (Exception E) {
            System.out.println("Input error, try again");
        }
    }

    /**
     * Calls the delete method on a given LinkedListProgram object with a
     * ListNode object from input()
     *
     * @param list LinkedListProgram object, the given linked list which a new
     *             ListNode object is deleted from
     */
    public static void delete(LinkedListProgram<Integer> list) {
        try {
            list.delete(input());
        } catch (Exception E) {
            System.out.println("Input error, try again");
        }
    }

    /**
     * Runs an action on a given LinkedListProgram object depending on the given
     * command
     *
     * @param input character for a given command
     * @param list  LinkedListProgram object to run an action on
     */
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

    /**
     * Gets user input for a character to be used in run()
     *
     * @return character from user input
     * @throws IOException
     */
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
