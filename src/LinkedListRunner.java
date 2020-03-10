import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedListRunner<E extends Comparable<E>> {

	public void readFile() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter relative path of file: ");
		FileReader readFile = new FileReader(in.readLine());
		BufferedReader inFile = new BufferedReader(readFile);
		System.out.println("\nReading File...\n");
		String input = inFile.readLine();
		while (input != null) {
			tokenizeString(input);
			input = inFile.readLine();
		}
		System.out.println("Reading Complete.");
		inFile.close();
	}

	private void tokenizeString(String input) {
	        StringTokenizer st = new StringTokenizer(input);
	        while (st.hasMoreTokens()) {
	            ListNode<Person> temp = new ListNode<Person>(new Person(st.nextToken(), st.nextToken(), st.nextToken()), null,null);
	        }
	    }
}
