package service;

import Utils.SystemService;
import domain.Room;
import domain.RoomHistory;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static Config.Constants.*;

public class RoomInfoService {
    private final SystemService systemService = new SystemService();
    /**
     * This method prints the room occupancy review. Only Rooms that are occupied will be printed.
     */
    public void roomOccupancyReview(List<Room> hotelRooms) {
        System.out.println(ROOM_OCCUPANCY_REVIEW_MSG);
        hotelRooms.stream().filter(Room::getOccupied).forEach(room -> {
            System.out.println(ROOM_MSG + room.getRoomNumber() + ": " + room.getGuest());
        });
        systemService.waitForEnter();
    }

    /**
     * This method prints the room status and room history log.
     */
    public void roomHistoryAndStatus(List<Room> hotelRooms, List<RoomHistory> roomsHistoryList) {
        // print room status
        System.out.println(ROOM_STATUS_MSG);
        for (Room room : hotelRooms) {
            System.out.print(ROOM_MSG + room.getRoomNumber() + ": ");
            if (room.getOccupied()) {
                System.out.println(OCCUPIED_MSG + room.getGuest());
            } else {
                System.out.println(AVAILABLE_MSG);
            }
        }
        // print room history log
        System.out.println(ROOM_HISTORY_LOG_MSG);
        for (Room room : hotelRooms) {
            Integer roomNumber = room.getRoomNumber();
            //print room number
            System.out.print(ROOM_MSG + roomNumber + ": " + "\n");
            //print room history of the room
            roomsHistoryList.stream().
                    filter(roomHistory -> roomHistory.getRoomNumber().equals(roomNumber)).
                    forEach(roomHistory -> System.out.println(printHistoryLog(roomHistory)));
        }
        systemService.waitForEnter();
    }

    /**
     * Generate a history log message for a given room history.
     *
     * @param roomHistory The room history object.
     * @return The formatted history log message.
     */
    private String printHistoryLog(RoomHistory roomHistory) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (roomHistory.getCheckOutDate() != null) {
            return  String.format(HISTORY_LOG_MSG,
                    roomHistory.getGuest(),
                    roomHistory.getCheckInDate().format(formatter),
                    roomHistory.getCheckOutDate().format(formatter)
            );
        } else {
            return  String.format(HISTORY_LOG_MSG,
                    roomHistory.getGuest(),
                    roomHistory.getCheckInDate().format(formatter),
                    "not checked out"
            );
        }
    }
}
