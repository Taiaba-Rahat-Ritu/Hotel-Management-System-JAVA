package dev.rest;

import dev.domain.User;
import dev.domain.UserAddress;
import dev.domain.UserDetail;
import dev.service.UserAddressService;
import dev.service.UserDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserAddressRestController {

    private UserAddressService userAddressService;

    public UserAddressRestController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @GetMapping("/usersaddress")
    public List<UserAddress> getUserAddress() {
        return userAddressService.getAll();
    }

    @GetMapping("/usersaddress/{id}")
    public UserAddress getSpecificUserAddress(@PathVariable("id") Integer id) {
        return userAddressService.get(id);
    }
    @PutMapping("/usersaddress/{id}")
    public String UpdateUser(@PathVariable("id") Integer id, @RequestBody UserAddress userAddress) {

        userAddressService.edit(userAddress);
        return "Successful users address Updated";
    }
    @DeleteMapping("/usersaddress/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userAddressService.delete(id);
        return "Successful";
    }

    @PostMapping("/usersaddress")
    public String createUser(@RequestBody UserAddress userAddress) {
        userAddressService.create(userAddress);
        return "Successful";
    }
}
