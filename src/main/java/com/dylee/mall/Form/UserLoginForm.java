package com.dylee.mall.Form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    @NotBlank //判断是否为空或空格
    //@NotEmpty  判断list 集合 是否为空
    //@NotNull   判断是否为空字符
    private String username;

    @NotBlank
    private String password;

}
