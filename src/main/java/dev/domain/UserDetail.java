package dev.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "bloodGroup")
    private String bloodGroup;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userDetail", fetch = FetchType.EAGER)
    private List<UserAddress> userAddresses;

    public UserDetail() {
    }

    public UserDetail(int id, String nationality, String bloodGroup, User user, List<UserAddress> userAddresses) {
        this.id = id;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.user = user;
        this.userAddresses = userAddresses;
    }
/*    public UserDetail(int id, String nationality, String bloodGroup, User user) {
        this.id = id;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.user = user;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }


    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
