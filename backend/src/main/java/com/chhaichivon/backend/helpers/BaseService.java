package com.chhaichivon.backend.helpers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:24 PM
 */
public interface  BaseService<T> {
    Page<T> findAll(Pageable pageable);
    T findById(long id);
    T save(T t);
    T update(T t);
    void delete(long id);
}