package dev.service;

import dev.domain.User;
import dev.domain.UserAddress;
import dev.domain.UserDetail;
import dev.repository.UserAddressRepository;
import dev.repository.UserDetailRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserAddressService {

    private UserAddressRepository userAddressRepository;

    public UserAddressService(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    public void create(UserAddress userAddress) {
        userAddressRepository.create(userAddress);
    }

    public List<UserAddress> getAll() {
        return userAddressRepository.getAll();
    }

    public UserAddress get(int id) {
        return userAddressRepository.get(id);
    }
    public void edit(UserAddress userAddress) {
        userAddressRepository.edit(userAddress);
    }

    public void delete(int id) {
        userAddressRepository.delete(id);
    }
}
