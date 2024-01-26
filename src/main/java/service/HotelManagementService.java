package service;

import domain.Room;
import domain.RoomHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static config.Constants.*;

public class HotelManagementService {

    private final List<Room> hotelRooms = new ArrayList<>();
    private final List<RoomHistory> roomsHistoryList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final RoomService roomService = new RoomService();
    private final RoomInfoService roomInfoService = new RoomInfoService();

    /**
     * Runs the hotel management application.
     */
    public void runApp() {
        // initialize hotel rooms
        int numberOfRoomsInHotel = 5;
        for (int i = 1; i <= numberOfRoomsInHotel; i++) {
            Room room = new Room();
            room.setRoomNumber(i);
            room.setOccupied(false);
            hotelRooms.add(room);
        }
        // run application
        while (true) {
            // display main menu
            System.out.println(MAIN_MENU);
            // Get user choice
            String choice = scanner.nextLine().trim();
            // Handle user choice
            switch (choice) {
                case "1":
                    roomService.checkInGuest(hotelRooms, roomsHistoryList);
                    break;
                case "2":
                    roomService.checkOutGuest(hotelRooms, roomsHistoryList);
                    break;
                case "3":
                    roomInfoService.roomOccupancyReview(hotelRooms);
                    break;
                case "4":
                    roomInfoService.roomHistoryAndStatus(hotelRooms, roomsHistoryList);
                    break;
                case "5":
                    System.out.println(EXIT_MSG);
                    System.exit(0);
                    break;
                default:
                    System.out.println(INVALID_INPUT_MSG);
                    break;
            }
        }
    }
}
