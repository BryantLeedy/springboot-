package com.dylee.mall.vo;

import com.dylee.mall.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.util.Objects;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)  //如果数据为null，则不返回
public class ResponseVo<T> {
    private Integer status;

    private  String msg;

    private T Data;

    public ResponseVo(Integer status,String msg){
        this.status= status;
        this.msg = msg;
    }

    public ResponseVo(Integer status, T data) {
        this.status = status;
        Data = data;
    }

    public static <T>ResponseVo<T> successByMsg(String msg){
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),msg);
    }
    public static <T>ResponseVo<T> success(T data){
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),data);
    }
    public static <T>ResponseVo<T> success(){
        return new ResponseVo<>(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getDesc());
    }
    public static <T>ResponseVo<T> error(ResponseEnum responseEnum){
        return new ResponseVo<>(responseEnum.getCode(),responseEnum.getDesc());
    }
    public static <T>ResponseVo<T> error(ResponseEnum responseEnum,String msg){
        return new ResponseVo<>(responseEnum.getCode(),msg);
    }
    public static <T>ResponseVo<T> error(ResponseEnum responseEnum, BindingResult bindingResult){
        return new ResponseVo<>(responseEnum.getCode(),
                           Objects.requireNonNull(bindingResult.getFieldError()).getField() +" " +
                                bindingResult.getFieldError().getDefaultMessage());
    }
}

