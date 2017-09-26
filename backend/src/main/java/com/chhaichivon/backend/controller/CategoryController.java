package com.chhaichivon.backend.controller;

import com.chhaichivon.backend.helpers.BaseController;
import com.chhaichivon.backend.models.Category;
import com.chhaichivon.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/30/2017
 * TIME   : 9:46 AM
 */
@RestController
@RequestMapping(value = "/api")
public class CategoryController extends BaseController<Category> {
    @Autowired
    private CategoryService categoryService;
    public Map<String, Object> map;

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Category>> getAllCategory(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    ) {
        Page<Category> categories = null;
        try {
            categories = categoryService.findAll(new PageRequest(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findCategoryById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Category category = new Category();
        try {
            category = categoryService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(category);
    }


    @RequestMapping(value = "/categories", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> saveCategory(@RequestBody Category category) {
        map = new HashMap<>();
        try {
            if (category != null) {
                categoryService.save(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(category);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateCategory(@PathVariable("id") Long id, @RequestBody Category newCategory) {
        map = new HashMap<>();
        Category oldCategory = categoryService.findById(id);
        try {
            if (oldCategory != null) {
                oldCategory.setName(newCategory.getName());
                oldCategory.setDescription(newCategory.getDescription());
                categoryService.update(oldCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(oldCategory);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> deleteCategory(@PathVariable("id") long id) {
        map = new HashMap<>();
        Category category = categoryService.findById(id);
        try {
            if (category != null) {
                categoryService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(category);
    }
}
