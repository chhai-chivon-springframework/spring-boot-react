package com.chhaichivon.backend.services;

import com.chhaichivon.backend.models.User;
import com.chhaichivon.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/30/2017
 * TIME   : 4:36 PM
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(long id) {
        return userRepository.findOne(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.delete(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
