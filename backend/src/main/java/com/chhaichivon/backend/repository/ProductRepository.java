package com.chhaichivon.backend.repository;

import com.chhaichivon.backend.models.Product;
import com.chhaichivon.backend.utils.Pagination;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:30 PM
 */
@Repository
@Transactional
public class ProductRepository{
    @Autowired
    private SessionFactory sessionFactory;
    public Product findById(long id) {
        return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class,"category") .add(Restrictions.eq("category.id",id)).uniqueResult();
    }

    public Boolean save(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return true;
    }

    public Boolean update(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
        return true;
    }

    public Boolean delete(long id) {
        Product product = sessionFactory.getCurrentSession().load(Product.class, id);
        sessionFactory.getCurrentSession().delete(product);
        return true;
    }
    public List<Product> findAll(Pagination pagination) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
        criteria.setFirstResult(pagination.offset());
        criteria.setMaxResults(pagination.getLimit());
        List<Product> products = (List<Product>) criteria.list();
        return products;
    }
}