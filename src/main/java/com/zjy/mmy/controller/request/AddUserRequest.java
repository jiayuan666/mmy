package com.zjy.mmy.controller.request;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String openID;
    private String nickname;
    private String phone;
}
