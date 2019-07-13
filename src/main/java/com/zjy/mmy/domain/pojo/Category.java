package com.zjy.mmy.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * `category_id` int(5) NOT NULL,
 *   `category_name` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class Category {
    public int categoryID;
    public String categoryName;

}
