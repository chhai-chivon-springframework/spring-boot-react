package com.chhaichivon.backend.forms;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/30/2017
 * TIME   : 4:41 PM
 */
@Data
public class RoleForm implements Serializable{

    @Column(nullable = false)
    private String roleName;

    @Column(nullable = false)
    private String description;
}
