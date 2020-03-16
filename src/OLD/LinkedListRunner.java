package OLD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedListRunner<E extends Comparable<E>> {

    /**
     * File reader method, reads file, converts to OLD.Person objects and adds to
     * list
     *
     * @param list OLD.LinkedListProgram object to add new OLD.Person objects to
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
        System.out.println("Reading Complete.\n");
        inFile.close();
    }

    /**
     * Uses String Tokenizer to convert file text to OLD.Person objects, adds to
     * list
     *
     * @param input String, one line from the given file
     * @param list  OLD.LinkedListProgram object to add new OLD.Person objects to
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
        // list.printReverseList();
    }

}

// OUTPUT

/*

Enter relative path of file: PersonList.txt

Reading File...

Reading Complete.

First Name: Alice
Last Name: Ardvaark
Employer: IBM

First Name: Zoe
Last Name: Field
Employer: APL

First Name: Ima
Last Name: Geek
Employer: DGT

First Name: Sally
Last Name: Guest
Employer: DGT

First Name: Zoe
Last Name: Guest
Employer: APL

First Name: Asdfgh
Last Name: Keys
Employer: DGT

First Name: Qwerty
Last Name: Keys
Employer: IBM

First Name: Cal
Last Name: Kulate
Employer: DGT

First Name: Linc
Last Name: List
Employer: APL

First Name: Iluv
Last Name: Math
Employer: DGT

First Name: Doyour
Last Name: Math
Employer: DGT

First Name: Ura
Last Name: Nerd
Employer: IBM

First Name: Blaise
Last Name: Pascal
Employer: APL

First Name: Sally
Last Name: Pascal
Employer: FCA

First Name: Suzy
Last Name: Queue
Employer: IBM

First Name: Mike
Last Name: Rochip
Employer: DGT

First Name: Amy
Last Name: Rochip
Employer: IBM

First Name: Genevieve
Last Name: Stapos
Employer: DGT

First Name: Closda
Last Name: Windoes
Employer: APL

First Name: Howard
Last Name: Yadoing
Employer: DGT

*/