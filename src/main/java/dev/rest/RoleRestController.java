package dev.rest;

import dev.domain.Role;
import dev.domain.RoomType;
import dev.domain.User;
import dev.service.RoleService;
import dev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleRestController {

    private RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getroles() {
        return roleService.getAll();
    }

    @GetMapping("/roles/{id}")
    public Role getSpecificroles(@PathVariable("id") Integer id) {
        return roleService.get(id);
    }

    @PostMapping("/roles")
    public String createroles(@RequestBody Role role) {
        roleService.create(role);
        return "Successful";
    }

    @PutMapping("/roles/{id}")
    public String Updateroles(@PathVariable("id") Integer id, @RequestBody Role role) {

        roleService.edit(role);
        return "Successful Role Updated";
    }

    @DeleteMapping("/roles/{id}")
    public String deleteroles(@PathVariable("id") Integer id) {
        roleService.delete(id);
        return "Successful";
    }


}
