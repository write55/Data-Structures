import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedListRunner<E extends Comparable<E>> {

    /**
     *
     * @param list
     * @throws IOException
     */
    public static void readFile(LinkedListProgram<Person> list) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            tokenizeString(input, list);
            input = inFile.readLine();
        }
        System.out.println("Reading Complete.");
        inFile.close();
    }

    /**
     *
     * @param input
     * @param list
     */
    private static void tokenizeString(String input, LinkedListProgram<Person> list) {
        StringTokenizer st = new StringTokenizer(input);
        ListNode<Person> mid = new ListNode<Person>(new Person("", "N", ""), null, null);
        while (st.hasMoreTokens()) {
            list.add(new ListNode<Person>(new Person(st.nextToken(), st.nextToken(), st.nextToken()), null, null), mid);
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedListProgram<Person> list = new LinkedListProgram<Person>();
        readFile(list);
        list.printList();
    }


}
