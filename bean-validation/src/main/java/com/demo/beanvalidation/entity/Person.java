package com.demo.beanvalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull(message = "classid不能为空")
    @Min(0)
    private String classId;
    //被注释的元素的大小必须在指定的范围内
    @Size(max = 33)
    @NotNull(message = "name不能为空")
    private String name;
    @Pattern(regexp = "((^Man$|^Women$|^UGM$))", message = "sex值不在可选范围")
    @NotNull(message = "sex不能为空")
    private String sex;
    @Email(message = "email格式不正确")
    @NotNull(message = "email格式不能为空")
    private String email;
}
