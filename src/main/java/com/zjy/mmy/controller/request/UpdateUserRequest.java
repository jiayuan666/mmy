package com.zjy.mmy.controller.request;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    private Integer userID;
    private String nickname;
    private String phone;
}
