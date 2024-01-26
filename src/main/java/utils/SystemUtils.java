package utils;

import java.util.Scanner;

import static config.Constants.PRESS_ENTER_TO_CONTINUE_MSG;

public class SystemUtils {

    /**
     * Method to pause the program to see the output. To continue program user must press enter.
     */
    public void waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRESS_ENTER_TO_CONTINUE_MSG);
        scanner.nextLine();
    }
}
