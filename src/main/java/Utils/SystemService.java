package Utils;

import java.util.Scanner;

import static Config.Constants.PRESS_ENTER_TO_CONTINUE_MSG;

public class SystemService {

    /**
     * Method to pause the program to see the output. To continue program user must press enter.
     */
    public void waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRESS_ENTER_TO_CONTINUE_MSG);
        scanner.nextLine();
    }
}
