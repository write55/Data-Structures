import java.io.*;
import java.util.Scanner;

public class BSTProgram {

    /**
     * Method to enter commands via user input in the console, currently unused but here if you need it
     */
    public static void getInput() throws IOException {
        BST<Integer> bst = new BST<Integer>();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Command: ");
        String cmd = in.readLine().toUpperCase();
        while (!cmd.equals("QUIT")) {
            run(cmd, bst);
            System.out.print("New Command: ");
            cmd = in.readLine().toUpperCase();
        }
        System.out.println("Program complete");
    }

    /**
     * Method to get user input to locate the script as a text file and run commands
     */
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

    /**
     * Run commands to add or remove integers from the tree, or to print it out in inorder, preorder, and postorder traversal
     *
     * @param input String containing a command to run
     * @param bst   The current binary search tree to execute the command on
     */
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

    public static void main(String[] args) throws IOException {
        // getInput();
        getScript();
    }
}

/*

Enter filepath of script: C:\Users\write\IdeaProjects\Data-Structures\script.txt
Tree empty

13 added
10 added
20 added
12 added
15 added
5 added
PreOrder Traversal:
[ 13 10 5 12 20 15 ]

InOrder Traversal:
[ 5 10 12 13 15 20 ]

PostOrder Traversal:
[ 5 12 10 15 20 13 ]

10 deleted
13 deleted
30 added
40 added
11 added
Data not in tree
15 deleted
20 deleted
13 deleted
35 added
50 added
Data not in tree
10 deleted
13 deleted
30 deleted
13 deleted
InOrder Traversal:
[ 10 11 12 13 15 30 35 40 50 ]

40 deleted
30 deleted
13 deleted
2 added
30 deleted
15 deleted
Data not in tree
40 deleted
30 deleted
15 deleted
12 deleted
11 deleted
15 deleted
11 deleted
15 deleted
InOrder Traversal:
[ 11 12 15 30 35 40 ]

30 deleted
11 deleted
30 deleted
40 deleted
35 deleted
40 deleted
PostOrder Traversal:
[ 11 ]

10 added
15 added
20 added
5 added
PreOrder Traversal:
[ 11 10 5 15 20 ]

InOrder Traversal:
[ 5 10 11 15 20 ]

PostOrder Traversal:
[ 5 10 20 15 11 ]

Program complete

 */