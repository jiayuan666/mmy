package com.zjy.mmy.domain.pojo;

import lombok.*;

import java.util.List;

/**
 * `image_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
 *   `good_id` int(10) unsigned zerofill NOT NULL,
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Image {
    public Integer imageID;
    public Integer goodID;
}
