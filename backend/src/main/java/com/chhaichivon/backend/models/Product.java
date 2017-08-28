package com.chhaichivon.backend.models;

import com.chhaichivon.backend.helpers.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 2:28 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product extends BaseEntity{
    @JsonProperty("PRO_NAME")
    @Column(nullable = false)
    private String proName;
    @JsonProperty("PRICE")
    @Column(nullable = false)
    private String price;
    @JsonProperty("IMAGE")
    @Column(nullable = false)
    private String image;
}