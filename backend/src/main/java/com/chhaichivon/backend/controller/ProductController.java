package com.chhaichivon.backend.controller;

import com.chhaichivon.backend.forms.ProductForm;
import com.chhaichivon.backend.helpers.BaseController;
import com.chhaichivon.backend.models.Category;
import com.chhaichivon.backend.models.Product;
import com.chhaichivon.backend.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:19 PM
 */
@RestController
@RequestMapping(value = "/api")
public class ProductController extends BaseController<Product> {

    @Autowired
    private ProductServiceImpl productService;
    public Map<String, Object> map;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Product>> getAllProduct(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    ) {
        Page<Product> products = null;
        try {
            products = productService.findAll(new PageRequest(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(products);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findProductById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Product product = null;
        try {
            product = productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody ProductForm productForm) {
        map = new HashMap<>();
        Product product = new Product();
        Category category = new Category();
        try {
            if (productForm != null) {
                product.setProductName(productForm.getProName());
                product.setPrice(productForm.getProName());
                product.setImage(productForm.getImage());
                product.setCategory(category);
                if (product != null) {
                    productService.save(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateProduct(@PathVariable("id") Long id, @RequestBody ProductForm productForm) {
        map = new HashMap<>();
        Product product = null;
        try {
            product = productService.findById(id);
            if (product != null) {
                product.setProductName(productForm.getProName());
                product.setPrice(productForm.getPrice());
                product.setImage(productForm.getImage());
                productService.update(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable("id") long id) {
        map = new HashMap<>();
        Product product = productService.findById(id);
        try {
            if (product != null) {
                productService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(product);
    }
}