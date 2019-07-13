package com.zjy.mmy.domain.pojo;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 *   `good_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
 *   `good_name` varchar(255) NOT NULL,
 *   `user_id` int(10) NOT NULL,
 *   `price` decimal(10,2) NOT NULL,
 *   `stock` int(11) NOT NULL,
 *   `detail` varchar(255),
 *   `trade` varchar(255) NOT NULL,
 *   `category_id` int(5) NOT NULL,
 *   `date` timestamp NOT NULL,
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Good implements Serializable {
    private Integer goodID;
    private String goodName;
    private User user;
    private BigDecimal price;
    private Integer stock;
    private String detail;
    private List<String> trades;
    private Category category;
    private Timestamp date;

}
