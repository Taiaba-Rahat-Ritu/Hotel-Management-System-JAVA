
package dev.rest;
import dev.domain.Staff;

import dev.service.StaffService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StaffRestController {
    private StaffService staffService;

    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staffs")
    public List<Staff> getStaffs() {
        return staffService.getAll();
    }

    @GetMapping("/staffs/{staffId}")
    public Staff getSpecificStaff(@PathVariable("staffId") Integer staffId) {
        return staffService.get(staffId);
    }

    @PutMapping("/staffs/{staffId}")
    public String UpdateStaff(@PathVariable("staffId") Integer staffId, @RequestBody Staff staff) {

        staffService.edit(staff);
        return "Successful Staff Updated";
    }

    @DeleteMapping("/staffs/{staffId}")
    public String deleteStaff(@PathVariable("staffId") Integer staffId) {
        staffService.delete(staffId);
        return "Successful";
    }

    @PostMapping("/staffs")
    public String createStaff(@RequestBody Staff staff) {
        staffService.create(staff);
        return "Successful";
    }
}
