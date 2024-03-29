package dev.rest;

import dev.domain.Hotel;
import dev.domain.User;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.get(id);
    }
    @PutMapping("/users/{id}")
    public String UpdateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        userService.edit(user);
        return "Successful User Updated";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "Successful";
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        userService.create(user);
        return "Successful";
    }
}
