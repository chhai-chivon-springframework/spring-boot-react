package com.chhaichivon.backend.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:36 PM
 */
public abstract class BaseController<T> {

    public static final String MESSAGE_SUCCESS = "SUCCESS";
    public static final String MESSAGE_FAILURE = "FAIL";
    private Map<String, Object> map = new HashMap<>();

    /*public Response responseStatus(T item) {
        if (item != null) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    public Response responseContent(T item) {
        if (item != null) {
            return Response.ok(item).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
        //return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();    }
    }*/

    private Map<String, Object> mapJson(T object, HttpStatus status, String message) {
        map.put("DATA", object);
        map.put("STATUS", status);
        map.put("MESSAGE", message);
        return map;
    }

    public ResponseEntity<Map<String, Object>> responseJson(T object) {
        if (object != null) {
            map = mapJson(object, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> responseJson(List<T> objects) {
        if (!objects.isEmpty()) {
            map = mapJson((T) objects, HttpStatus.OK, MESSAGE_SUCCESS);
        } else {
            map = mapJson(null, HttpStatus.NOT_FOUND, MESSAGE_FAILURE);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}