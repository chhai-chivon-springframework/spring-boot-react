package com.chhaichivon.backend.services;

import com.chhaichivon.backend.models.Role;
import com.chhaichivon.backend.repository.RoleRepository;
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
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    public Role findById(long id) {
        return roleRepository.findOne(id);
    }


    public Role save(Role role) {
        return roleRepository.save(role);
    }


    public Role update(Role role) {
        return roleRepository.save(role);
    }


    public void delete(long id) {
        roleRepository.delete(id);
    }
}
