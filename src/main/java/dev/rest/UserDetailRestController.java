package dev.rest;

import dev.domain.User;
import dev.domain.UserDetail;
import dev.service.UserDetailService;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetailRestController {

    private UserDetailService userDetailService;

    public UserDetailRestController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }





    @GetMapping("/userDetail")
    public List<UserDetail> getUserDetails() {
        return userDetailService.getAll();
    }

    @GetMapping("/userDetail/{id}")
    public UserDetail getDetails(@PathVariable("id") Integer id) {
        return userDetailService.get(id);
    }
    @PutMapping("/userDetail/{id}")
    public String UpdateDetails(@PathVariable("id") Integer id, @RequestBody UserDetail userDetail) {

        userDetailService.edit(userDetail);
        return "Successful User Updated";
    }
    @DeleteMapping("/userDetail/{id}")
    public String deleteDetails(@PathVariable("id") Integer id) {
        userDetailService.delete(id);
        return "Successful";
    }

    @PostMapping("/userDetail")
    public String createUser(@RequestBody UserDetail userDetail) {
            userDetailService.create(userDetail);
        return "Successful";
    }
}
