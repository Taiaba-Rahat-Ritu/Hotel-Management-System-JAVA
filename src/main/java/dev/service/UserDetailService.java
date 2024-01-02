package dev.service;

import dev.domain.User;
import dev.domain.UserDetail;
import dev.repository.UserDetailRepository;
import dev.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserDetailService {

    private UserDetailRepository userDetailRepository;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    public void create(UserDetail userDetail) {
        userDetailRepository.create(userDetail);
    }

    public List<UserDetail> getAll() {
        return userDetailRepository.getAll();
    }


    public UserDetail get(int id) {
        return userDetailRepository.get(id);
    }
    public void edit(UserDetail userDetail) {
        userDetailRepository.edit(userDetail);
    }

    public void delete(int id) {
        userDetailRepository.delete(id);
    }
}
