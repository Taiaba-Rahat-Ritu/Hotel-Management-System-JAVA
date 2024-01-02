package dev.service;
import dev.domain.Staff;
import dev.repository.StaffRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StaffService {

    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public void create(Staff staff) {
        staff.setStaffId(staff.getStaffId());
        staffRepository.create(staff);
    }

    public List<Staff> getAll() {
        return staffRepository.getAll();
    }

    public Staff get(int staffId) {
        return staffRepository.get(staffId);
    }
    public void edit(Staff staff) {
        staffRepository.edit(staff);
    }


    public void delete(int staffId) {
        staffRepository.delete(staffId);
    }
}
