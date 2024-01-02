package dev.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room") // change to an appropriate column name
    private int room;

    @NotNull
    @Column(name = "hotelId")
    private int hotelId;
    @JsonIgnore
    @NotNull
    @Column(name = "roomTypesId")
    private int roomTypesId;

    @NotNull
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId", insertable = false, updatable = false)

    private Hotel hotel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomTypesId", insertable = false, updatable = false)
    private RoomType roomType;

    public Room() {
    }

    public Room(int room, int hotelId, int roomTypesId, String status, Hotel hotel, RoomType roomType) {
        this.room = room;
        this.hotelId = hotelId;
        this.roomTypesId = roomTypesId;
        this.status = status;
        this.hotel = hotel;
        this.roomType = roomType;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomTypesId() {
        return roomTypesId;
    }

    public void setRoomTypesId(int roomTypesId) {
        this.roomTypesId = roomTypesId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


}

