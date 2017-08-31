package com.chhaichivon.backend.models;

import com.chhaichivon.backend.enums.UserProfileType;

import javax.persistence.*;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/31/2017
 * TIME   : 9:00 AM
 */
@Entity
@Table(name="USER_PROFILE")
public class UserProfile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="TYPE", length=15, unique=true, nullable=false)
    private String type = UserProfileType.USER.getUserProfileType();
}
