package com.chhaichivon.backend.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 3:01 PM
 */
@Data
public class ProductForm implements Serializable{
    @JsonProperty("PRO_NAME")
    private String proName;
    @JsonProperty("PRICE")
    private String price;
    @JsonProperty("IMAGE")
    private String image;

}
