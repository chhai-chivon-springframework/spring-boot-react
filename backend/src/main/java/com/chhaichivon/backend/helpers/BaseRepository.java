package com.chhaichivon.backend.helpers;



import com.chhaichivon.backend.utils.Pagination;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:23 PM
 */
public interface BaseRepository<T> {
    public T findById(long id);
    public Boolean save(T entity);
    public Boolean update(T entity);
    public Boolean delete(long id);
    public List<T> findAll(Pagination entityPage);
}