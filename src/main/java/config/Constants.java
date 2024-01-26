package config;

public interface Constants {
     String MAIN_MENU = " Hotel Management System Menu \n" +
                           "1. Guest Registration \n" +
                           "2. Check-out of the Guest \n" +
                           "3. Room Occupancy Review \n" +
                           "4. History and Status of the Room \n" +
                           "5. Exit \n" +
                           "Enter your choice using numbers: ";
     String EXIT_MSG = "Exiting program. Thank you for using our service!";
     String ROOM_OCCUPANCY_REVIEW_MSG = "Room Occupancy Review:";
     String INVALID_INPUT_MSG = "Invalid input entered. Please try again.";String ENTER_NAME_MSG = "Enter guest name: ";
     String ENTER_LAST_NAME_MSG = "Enter guest last name: ";
     String GUEST_REGISTERED_MSG = "Guest registered successfully. Room Number: ";
     String NO_ROOMS_MSG = "Sorry, no rooms available at the moment.";
     String ROOM_STATUS_MSG = "Room Status:";
     String ENTER_ROOM_NR_TO_CHECK_OUT_MSG = "Enter room number for check-out: ";
     String ROOM_IS_NOT_OCCUPIED_MSG = ". room is not occupied";
     String CHECKING_OUT_MSG = "Checking out guest: ";
     String ROOM_MSG = "Room ";
     String OCCUPIED_MSG = "Occupied by ";
     String AVAILABLE_MSG = "Available";
     String ROOM_HISTORY_LOG_MSG = "Room History Log:";
     String PRESS_ENTER_TO_CONTINUE_MSG = "Press enter to continue...";
     String HISTORY_LOG_MSG = "guest: %s, checkInDate : %s, checkOutDate : %s";

}
