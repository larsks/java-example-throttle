package Pck1;

import java.util.Scanner;

public class MainClass {
    /**
     * Prompt the user for a new Throttle position. This routine will
     * loop until the user enters valid data, re-prompting the user each
     * time.
     */
    private static int readPosition(Scanner input) {
        int position;

        // Keep prompting until we get valid input.
        while (true) {
            System.out.print("Enter throttle position (0-6); enter -1 to quit: ");
            try {
                position = input.nextInt();
                if (position >= -1 && position <= 6)
                    // Exit the loop if we have valid data.
                    break;
            } catch (java.util.InputMismatchException e) {
                /**
                 * We end up here if the user enters a non-integer response.
                 * This call discards the invalid token so that we can try
                 * reading new input.
                 */
                input.next();
            }

            /**
             * If we get here, the user entered invalid data. Either they entered
             * a number that it out of range, or they entered some non-numeric
             * response. In either case, display an error and re-prompt.
             */
            System.out.println("Invalid input.");
        }

        return position;
    }

    public static void main(String[] args) {
        Throttle throttle;

        /**
         * This is a try-with-resources [1] statement; it ensures that we properly
         * close the scanner when we exit the try block. That's not strictly necessary
         * in this code, but it stops my IDE from complaining about the unclosed scanner.
         *
         * [1]: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
         */
        try (Scanner input = new Scanner(System.in)) {
            while(true) {
                int position = readPosition(input);

                if (position == -1) {
                    // Exit if user enters -1.
                    break;
                } else {
                    // Otherwise create a new Throttle with updated position.
                    throttle = new Throttle(position);
                }

                System.out.println("Flow is now: " + throttle.flow());
            }
        }
    }
}

