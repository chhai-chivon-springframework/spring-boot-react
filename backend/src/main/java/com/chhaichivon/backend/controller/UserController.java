package com.chhaichivon.backend.controller;

import com.chhaichivon.backend.forms.RoleForm;
import com.chhaichivon.backend.forms.UserForm;
import com.chhaichivon.backend.helpers.BaseController;
import com.chhaichivon.backend.models.Role;
import com.chhaichivon.backend.models.User;
import com.chhaichivon.backend.services.UserServiceImpl;
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
public class UserController extends BaseController<User> {

    @Autowired
    private UserServiceImpl userService;
    public Map<String, Object> map;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<User>> getAllUser(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "15") int limit
    ) {
        Page<User> users = null;
        try {
            users = userService.findAll(new PageRequest(page, limit));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(users);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> findProductById(@PathVariable("id") Long id) {
        map = new HashMap<>();
        User user = null;
        try {
            user = userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody UserForm userForm) {
        map = new HashMap<>();
        User user = new User();
        try {
            if (userForm != null) {
                user.setUserName(userForm.getUserName());
                user.setEmail(userForm.getEmail());
                user.setPassword(userForm.getPassword());
                if (user != null) {
                    userService.save(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> updateRole(@PathVariable("id") Long id, @RequestBody UserForm userForm) {
        map = new HashMap<>();
        User user = null;
        try {
            user = userService.findById(id);
            if (userForm != null) {
                user.setUserName(userForm.getUserName());
                user.setEmail(userForm.getEmail());
                user.setPassword(userForm.getPassword());
                userService.update(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String, Object>> deleteRole(@PathVariable("id") long id) {
        map = new HashMap<>();
        User user = userService.findById(id);
        try {
            if (user != null) {
                userService.delete(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseJson(user);
    }
}