package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RoomHistory {
    public Integer roomNumber;
    public Guest guest;
    public LocalDateTime checkInDate;
    public LocalDateTime checkOutDate;

    public RoomHistory(int roomNumber, Guest guest, LocalDateTime checkInDate) {
        this.roomNumber = roomNumber;
        this.guest = guest;
        this.checkInDate = checkInDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

}
