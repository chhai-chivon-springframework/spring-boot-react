package com.chhaichivon.backend.helpers;

import javax.persistence.*;
import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:22 PM
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

}