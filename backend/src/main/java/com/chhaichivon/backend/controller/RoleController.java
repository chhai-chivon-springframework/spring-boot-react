package com.chhaichivon.backend.controller;

import com.chhaichivon.backend.helpers.BaseController;
import com.chhaichivon.backend.models.Role;
import com.chhaichivon.backend.services.RoleService;
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
 * DATE   : 8/30/2017
 * TIME   : 4:41 PM
 */
@RestController
@RequestMapping(value = "/api")
public class RoleController extends BaseController<Role> {

    @Autowired
    private RoleService roleService;
    public Map<String, Object> map;

    @RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<Role>> getAllProduct(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    ) {
        Page<Role> roles = null;
        try {
            roles = roleService.findAll(new PageRequest(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(roles);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findProductById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        Role role = null;
        try {
            role = roleService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role);
    }


    @RequestMapping(value = "/roles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody Role role) {
        map = new HashMap<>();
        try {
            if (role != null) {
                roleService.save(role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateRole(@PathVariable("id") Long id, @RequestBody Role newRole) {
        map = new HashMap<>();
        Role oldRole = roleService.findById(id);
        try {
            if (oldRole != null) {
                oldRole.setName(newRole.getName());
                roleService.update(oldRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(oldRole);
    }

    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> deleteRole(@PathVariable("id") long id) {
        map = new HashMap<>();
        Role role = roleService.findById(id);
        try {
            if (role != null) {
                roleService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(role);
    }
}