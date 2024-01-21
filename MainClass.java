package Pck1;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        System.out.print("Enter initial speed between 0 and 6: ");
        int speed = input.nextInt();

        Throttle throttle = new Throttle(speed);

mainloop:
        while(throttle.is_on()) {
            int shift;

            System.out.println("Flow is now: " + throttle.flow());
            while (true) {
                System.out.print("Enter 'u' to shift up, 'd' to shift down, 'q' to quit: ");
                String answer = input.next();

                if (answer.equals("u")) {
                    shift = 1;
                    break;
                } else if (answer.equals("d")) {
                    shift = -1;
                    break;
                } else if (answer.equals("q")) {
                    break mainloop;
                } else {
                    System.out.println("Invalid input.");
                }
            }

            throttle.shift(shift);
        }
    }
}

