package dev.service;

import dev.domain.Role;
import dev.domain.User;
import dev.domain.UserAddress;
import dev.repository.RoleRepository;
import dev.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void create(Role role) {
        roleRepository.create(role);
    }

    public List<Role> getAll() {
        return roleRepository.getAll();
    }

    public Role get(int id) {
        return roleRepository.get(id);
    }
    public void edit(Role role) {
        roleRepository.edit(role);
    }

    public void delete(int id) {
        roleRepository.delete(id);
    }
}
