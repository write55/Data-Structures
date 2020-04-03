
// This file contains code for part 5 and runs the whole project and the output buffer

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixQueue {

    /**
     * Method to read in file of infix strings and push them to the queue
     *
     * @throws IOException
     */
    public static void readFile(MyLinkedQueue<String> queue) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            queue.enqueue(input);
            input = inFile.readLine();
        }
        System.out.println("Reading Complete.\n");
        inFile.close();
    }

    /**
     * Takes an infix expression, runs the program, and returns program output in readable format
     *
     * @param expression String, infix expression to be processed
     * @return String, output containing original Infix expression, converted to Postfix, and result
     */
    public static String buildOutput(String expression) {
        StringBuilder str = new StringBuilder();
        str.append("Infix: ").append(expression);
        expression = InfixPostfixConverter.infixToPostfix(expression);
        str.append(PostFixRunner.postFixCalculator(expression));
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        MyLinkedQueue<String> infixStrings = new MyLinkedQueue<>();
        OutputBuffer out = new OutputBuffer();
        readFile(infixStrings);
        while (!infixStrings.isEmpty()) {
            out.addToBuffer(buildOutput(infixStrings.dequeue()));
        }
        out.cleanBuffer();
    }
}

// OUTPUT

/*

Enter relative path of file: infix.txt

Reading File...

Reading Complete.

Infix: 9*(8-5)
Postfix: 9 8 5 - *
Result: 27

Infix: (9-8)*5
Postfix: 9 8 - 5 *
Result: 5

Infix: 3/(4*(5-(2+1)))
Postfix: 3 4 5 2 1 + - * /
Result: 0

Infix: (9/3)/3
Postfix: 9 3 / 3 /
Result: 1

Infix: 9/(3/3)
Postfix: 9 3 3 / /
Result: 9

Infix: ((2-(3+4))-1+4*3)/7
Postfix: 2 3 4 + - 1 - 4 3 * + 7 /
Result: 0

Infix: 5-(4+3/(2*1))
Postfix: 5 4 3 2 1 * / + -
Result: 0

Infix: 5/(4*(3-(2+1)))
Postfix: 5 4 3 2 1 + - * /
Arithmetic error
Empty Stack, input error

Infix: (8+8*(4-2))*(3+5-6)
Postfix: 8 8 4 2 - * + 3 5 + 6 - *
Result: 48

 */
