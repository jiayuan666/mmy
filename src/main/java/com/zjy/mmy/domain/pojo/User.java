package com.zjy.mmy.domain.pojo;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *   `user_id` int(10) NOT NULL AUTO_INCREMENT,
 *   `open_id` varchar(255) NOT NULL,
 *   `nickname` varchar(255) NOT NULL,
 *   `phone` varchar(11) NOT NULL,
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {
    private Integer userID;
    private String openID;
    private String nickname;
    private String phone;

}
