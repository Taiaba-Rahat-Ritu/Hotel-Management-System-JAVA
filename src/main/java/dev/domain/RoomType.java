package dev.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "room_types")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomTypesId")
    private int roomTypesId;
    @NotNull
    @Column(name = "roomName")
    private String roomName;
    @NotNull
    @Column(name = "roomDescription")
    private String roomDescription;
    @NotNull
    @Column(name = "roomPricePerNight")
    private String roomPricePerNight;
    @NotNull
    @Column(name = "roomCapacity")
    private int roomCapacity;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Room> rooms;

    // Constructors, getters, setters, and other methods


    public RoomType() {
    }

    public RoomType(int roomTypesId, String roomName, String roomDescription, String roomPricePerNight, int roomCapacity, List<Room> rooms) {
        this.roomTypesId = roomTypesId;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomPricePerNight = roomPricePerNight;
        this.roomCapacity = roomCapacity;
        this.rooms = rooms;
    }

    public int getRoomTypesId() {
        return roomTypesId;
    }

    public void setRoomTypesId(int roomTypesId) {
        this.roomTypesId = roomTypesId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomPricePerNight() {
        return roomPricePerNight;
    }

    public void setRoomPricePerNight(String roomPricePerNight) {
        this.roomPricePerNight = roomPricePerNight;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
