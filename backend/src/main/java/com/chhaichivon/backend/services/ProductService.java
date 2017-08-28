package com.chhaichivon.backend.services;

import com.chhaichivon.backend.helpers.BaseService;
import com.chhaichivon.backend.models.Product;
import com.chhaichivon.backend.repository.ProductRepository;
import com.chhaichivon.backend.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:33 PM
 */
@Service
public class ProductService implements BaseService<Product> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll(Pagination pagination) {
        return productRepository.findAll(pagination);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(long id) {
        return productRepository.delete(id);
    }
}
