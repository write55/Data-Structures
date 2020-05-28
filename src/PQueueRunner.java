
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PQueueRunner {

    /**
     * Method to get user input to locate the script as a text file and run commands
     */
    public static void getScript() throws FileNotFoundException {
        PQueue<Patient> ER = new PQueue<Patient>();
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter filepath of script: ");
        String filepath = sc1.nextLine();
        Scanner sc2 = new Scanner(new File(filepath));
        sc1.close();
        while (sc2.hasNext()) {
            run(sc2.nextLine(), ER);
        }
        sc2.close();
    }

    /**
     * Runs the program, enqueueing or dequeueing patients based on commands given
     *
     * @param input String containing command
     * @param heap  Current priority queue for the command to operate on
     */
    public static void run(String input, PQueue<Patient> heap) {
        if (input.isEmpty()) {
            return;
        }
        String[] inputs = input.split(" ");
        if (inputs[0].equals("E")) {
            heap.enqueue(new Patient(inputs[1], inputs[2], Integer.parseInt(inputs[3])));
        } else if (input.equals("D")) {
            Patient temp = heap.dequeue();
            if (temp != null) {
                System.out.println(temp.toString());
            } else {
                System.out.println("Queue Empty");
            }
        } else {
            System.out.println("Input Error");
        }
    }

    public static void main(String[] args) throws IOException {
        getScript();
    }

}

// OUTPUT
/*
Enter filepath of script: script.txt

First Name: Closda
Last Name: Windoes
Priority: 1


First Name: Ima
Last Name: Geek
Priority: 1


First Name: Blaise
Last Name: Pascal
Priority: 2


First Name: Sally
Last Name: Field
Priority: 3


First Name: Qwerty
Last Name: Keys
Priority: 4


First Name: Suzy
Last Name: Queue
Priority: 5


First Name: Cal
Last Name: Kulate
Priority: 5


First Name: April
Last Name: Field
Priority: 1


First Name: Sally
Last Name: Guest
Priority: 2


First Name: Howard
Last Name: Yadoing
Priority: 3


First Name: Data
Last Name: Field
Priority: 4


First Name: Zoe
Last Name: Guest
Priority: 7


First Name: Abe
Last Name: Ardvaark
Priority: 1


First Name: Doyour
Last Name: Math
Priority: 2


First Name: Iluv
Last Name: Math
Priority: 2


First Name: Alice
Last Name: Ardvaark
Priority: 6


First Name: Didja
Last Name: Windoes
Priority: 8


First Name: Electromagnetic
Last Name: Field
Priority: 8


First Name: Sally
Last Name: Pascal
Priority: 9


First Name: Ura
Last Name: Nerd
Priority: 9


First Name: Linc
Last Name: List
Priority: 9


First Name: Amy
Last Name: Rochip
Priority: 10


First Name: Genevieve
Last Name: Stapos
Priority: 10


First Name: Mike
Last Name: Rochip
Priority: 10


First Name: Asdfgh
Last Name: Keys
Priority: 10


First Name: Zoe
Last Name: Field
Priority: 10

Queue Empty

 */

// The script I used is this:
/*
E Zoe Field 10
E Suzy Queue 5
E Ura Nerd 9
E Cal Kulate 5
E Closda Windoes 1
E Blaise Pascal 2
E Sally Field 3
E Qwerty Keys 4
E Linc List 9
E Ima Geek 1

D
D
D
D
D
D
D

E Electromagnetic Field 8
E Zoe Guest 7
E Sally Guest 2
E April Field 1
E Asdfgh Keys 10
E Mike Rochip 10
E Amy Rochip 10
E Didja Windoes 8
E Data Field 4
E Howard Yadoing 3

D
D
D
D
D

E Alice Ardvaark 6
E Genevieve Stapos 10
E Abe Ardvaark 1
E Doyour Math 2
E Iluv Math 2

D
D
D

E Sally Pascal 9

D
D
D
D
D
D
D
D
D
D
D
D
 */