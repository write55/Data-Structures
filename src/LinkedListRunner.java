import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LinkedListRunner {
    // FILE READER METHODS
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
    }

    public static void main(String[] args) {

    }

//    public static void mainOld() throws IOException {
//        GuestList list = new GuestList();
//        list.readFile();
//        list.insertionSort();
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("\nCommands: \nG: Find a Guest\nL: List Guests\nN: Number of Guests\nA: Add a Guest\nR: Change a Response\nC: Display a Guest's Colleagues\nQ: Quit");
//        System.out.print("\nEnter a Command: ");
//        char input = in.readLine().toUpperCase().charAt(0);
//        while (input != 'Q') {
//            list.runStuff(input);
//            System.out.print("\nEnter a Command: ");
//            input = in.readLine().toUpperCase().charAt(0);
//        }
//        System.out.println("Program Complete, Quitting");
//    }
}
