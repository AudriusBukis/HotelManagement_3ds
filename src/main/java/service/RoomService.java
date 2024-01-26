package service;

import Utils.SystemService;
import domain.Guest;
import domain.Room;
import domain.RoomHistory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static Config.Constants.*;

public class RoomService {
    private final Scanner scanner = new Scanner(System.in);
    private final SystemService systemService = new SystemService();

    /**
     * Check-in a guest to the hotel room.
     */
    public void checkInGuest(List<Room> hotelRooms, List<RoomHistory> roomsHistoryList) {
        int roomNumber = findAvailableRoom(hotelRooms);
        if (roomNumber != -1) {
            // Prompt user to enter guest details
            System.out.print(ENTER_NAME_MSG);
            String name = scanner.nextLine().trim();
            System.out.print(ENTER_LAST_NAME_MSG);
            String lastName = scanner.nextLine().trim();

            // Create and register guest
            Guest guest = new Guest();
            guest.setName(name);
            guest.setLastName(lastName);
            roomsHistoryList.add(new RoomHistory(roomNumber, guest, LocalDateTime.now()));
            Room room = hotelRooms.get(roomNumber - 1);
            room.setGuest(guest);
            room.setOccupied(true);
            System.out.println(GUEST_REGISTERED_MSG + (roomNumber));
        } else {
            System.out.println(NO_ROOMS_MSG);
        }
        systemService.waitForEnter();
    }

    /**
     * Check out a guest from the hotel.
     */
    public void checkOutGuest(List<Room> hotelRooms, List<RoomHistory> roomsHistoryList) {
        // Prompt the user to enter the room number to check out
        System.out.print(ENTER_ROOM_NR_TO_CHECK_OUT_MSG);
        String roomNumberInput = scanner.nextLine().trim();
        int indexNumber;

        // Validate the input
        if (!roomNumberInput.matches("\\d+")) {
            System.out.println(INVALID_INPUT_MSG);
            systemService.waitForEnter();
        }else {
            indexNumber  = Integer.parseInt(roomNumberInput) - 1;
            // Check if the room is occupied
            if (indexNumber >= 0 && indexNumber < hotelRooms.size() && hotelRooms.get(indexNumber).getOccupied()) {
                // Print the guest being checked out
                System.out.println(CHECKING_OUT_MSG + hotelRooms.get(indexNumber).getGuest());
                // Check out the guest
                Room room = hotelRooms.get(indexNumber);
                room.setOccupied(false);
                room.setGuest(null);
                // Set the check-out date in the room history
                roomsHistoryList.stream().filter(roomHistory -> roomHistory.getRoomNumber() == indexNumber + 1 && roomHistory.getCheckOutDate() == null).findFirst().ifPresent(roomHistory -> {
                    roomHistory.setCheckOutDate(LocalDateTime.now());
                });
                systemService.waitForEnter();
            }else if (indexNumber >= 0 && indexNumber < hotelRooms.size() && !hotelRooms.get(indexNumber).getOccupied()){
                // If the room is not occupied, inform user that the room is not occupied
                System.out.println((indexNumber + 1) + ROOM_IS_NOT_OCCUPIED_MSG);
                systemService.waitForEnter();
            } else {
                // If the room number is bigger than the number of rooms, print an error message
                System.out.println(INVALID_INPUT_MSG);
                systemService.waitForEnter();
            }
        }
    }

    /**
     * This method finds the first available room number in the hotel.
     * If no available room is found, it returns -1.
     *
     * @return The room number of the first available room, or -1 if no room is available.
     */
    private int findAvailableRoom(List<Room> hotelRooms) {
        return hotelRooms.stream().filter(room -> !room.getOccupied()).findFirst().map(Room::getRoomNumber).orElse(-1);
    }
}
