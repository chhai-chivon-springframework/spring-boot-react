package com.chhaichivon.backend.repository;

import com.chhaichivon.backend.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/30/2017
 * TIME   : 9:49 AM
 */
@Repository
public interface  CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
