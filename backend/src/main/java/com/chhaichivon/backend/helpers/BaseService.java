package com.chhaichivon.backend.helpers;


import com.chhaichivon.backend.utils.Pagination;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:24 PM
 */
public interface  BaseService<T> {
    List<T> findAll(Pagination pagination);
    T findById(long id);
    boolean save(T t);
    boolean update(T t);
    boolean delete(long id);
}