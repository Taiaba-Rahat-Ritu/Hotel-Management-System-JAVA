package dev.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelID")
    private int hotelID;

    @NotNull
    @Column(name = "hotelName")
    private String hotelName;

    @NotNull
    @Size(min = 8)
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "hotelAddress")
    private String hotelAddress;


    @NotNull
    @Column(name = "phone")
    private String phone;


    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "stars")
    private int stars;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkinTime")
    private LocalDate checkinTime;

    @NotNull
    /*@Past*/
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkoutTime")
    private LocalDate checkoutTime;



   @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
   private List<Room> room;

    public Hotel(int hotelID, String hotelName, String password, String hotelAddress, String phone, String email, int stars, LocalDate checkinTime, LocalDate checkoutTime) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.password = password;
        this.hotelAddress = hotelAddress;
        this.phone = phone;
        this.email = email;
        this.stars = stars;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
    }

    public Hotel() {
    }

    public int getHotelID() {
        return hotelID;
    }
    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public LocalDate getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalDate checkinTime) {
        this.checkinTime = checkinTime;
    }

    public LocalDate getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDate checkoutTime) {
        this.checkoutTime = checkoutTime;
    }





}
