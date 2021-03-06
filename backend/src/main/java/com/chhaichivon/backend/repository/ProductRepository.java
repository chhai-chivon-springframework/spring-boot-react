package com.chhaichivon.backend.repository;

import com.chhaichivon.backend.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:30 PM
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}