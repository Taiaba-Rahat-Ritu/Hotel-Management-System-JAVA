package dev.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;
   /* @NotNull
    @Column(name = "customerId")
    private int customerId;*/
  /*  @NotNull
    @Column(name = "roomNumber")
    private int roomNumber;*/
    @NotNull
    //@Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkInDate")
    private Date checkInDate;
    @NotNull
    //@Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "checkOutDate")
    private Date checkOutDate;
    @NotNull
    @Column(name = "totalPrice")
    private String totalPrice;
    @JsonIgnore
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Payment> payments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomNumber")
    private Room room;


    public Booking()
    {

    }


    public Booking(int bookingId, Date checkInDate, Date checkOutDate, String totalPrice, List<Payment> payments, Customer customer, Room room) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.payments = payments;
        this.customer = customer;
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

   /* public int getCustomerId() {
        return customerId;
    }*/

/*    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }*/

   /* public int getRoomNumber() {
        return roomNumber;
    }*/

    /*public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }*/

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }


    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

}

