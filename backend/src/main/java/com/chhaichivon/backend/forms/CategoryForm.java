package com.chhaichivon.backend.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/30/2017
 * TIME   : 9:49 AM
 */
@Data
public class CategoryForm implements Serializable {
    @JsonProperty("CATEGORY_NAME")
    @Column(nullable = false)
    private String categoryName;
    @JsonProperty("DESCRIPTION")
    @Column(nullable = false)
    private String description;
}
