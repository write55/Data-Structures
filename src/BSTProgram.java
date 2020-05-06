import java.io.*;
import java.util.Scanner;

public class BSTProgram {

//    public static void getInput() throws IOException {
//        BST<Integer> bst = new BST<Integer>();
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Commands:\n");
//        System.out.print("Command: ");
//        String cmd = in.readLine().toUpperCase();
//        while (!cmd.equals("QUIT")) {
//            run(cmd, bst);
//            System.out.print("New Command: ");
//            cmd = in.readLine().toUpperCase();
//        }
//        System.out.println("Program complete");
//    }

    public static void getScript() throws FileNotFoundException {
        BST<Integer> bst = new BST<Integer>();
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter filepath of script: ");
        String filepath = sc1.nextLine();
        Scanner sc2 = new Scanner(new File(filepath));
        sc1.close();
        while (sc2.hasNext()) {
            run(sc2.nextLine(), bst);
        }
        sc2.close();
    }

    public static void run(String input, BST<Integer> bst) {
        if (input.isEmpty()) {
            return; // This is here to deal with the enter gaps between commands in the script because I was too lazy to go through and delete them all
        }
        if (input.equals("INORDER")) {
            bst.inOrder();
        } else if (input.equals("PREORDER")) {
            bst.preOrder();
        } else if (input.equals("POSTORDER")) {
            bst.postOrder();
        } else if (input.charAt(0) == 'A') {
            bst.add(Integer.parseInt(input.substring(2)));
        } else if (input.charAt(0) == 'D') {
            bst.delete(Integer.parseInt(input.substring(2)));
        } else if (input.equals("QUIT")) {
            System.out.println("Program complete");
        } else {
            System.out.println("Command not recognized, try again");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // getInput();
        getScript();
    }
}