package com.dylee.mall.exception;

import com.dylee.mall.enums.ResponseEnum;
import com.dylee.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.dylee.mall.enums.ResponseEnum.ERROR;

@ControllerAdvice
public class RuntimeExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    //@ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVo handle(RuntimeException e){
        return ResponseVo.error(ERROR,e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLoginHandle(){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ResponseVo notValidExceptionHandler(MethodArgumentNotValidException e){
//        BindingResult bindingResult = e.getBindingResult();
//        Objects.requireNonNull(bindingResult.getFieldError());
//        return ResponseVo.error(ResponseEnum.PARAM_ERROR,
//                bindingResult.getFieldError().getField() +" " + bindingResult.getFieldError().getDefaultMessage());
//    }
}
