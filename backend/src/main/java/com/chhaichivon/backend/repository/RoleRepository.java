package com.chhaichivon.backend.repository;

import com.chhaichivon.backend.models.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/30/2017
 * TIME   : 4:34 PM
 */
@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>{
}
