package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Delegate;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * spring validate 支持JSR303规范，使用hibernate-validate对这个规范进行实现
 * 允许自定义校验
 * 支持编程式校验
 * 快速失败
 * <a href="https://segmentfault.com/a/1190000023471742">...</a>
 *
 * @author luyunji
 */
@Data
@Validated/*使用在方法入参上*/
@Valid/*使用在嵌套引用和方法入参上*/
public class SpringValidate {

    @Length
    @NotNull(groups = Update.class)
    public String name;

    @Delegate/*使用在集合判断上*/
    @Valid
    public List<String> names;

    static class Update {

    }

    /**
     * 统一校验异常处理
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        return sb.toString();
    }



}
