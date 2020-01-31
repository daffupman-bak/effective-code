package io.daff.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 手机号验证注解
 * - 定义@Phone注解；
 * - 实现约束验证器PhoneValidator.java；
 * - 声明@Phone约束验证；
 * - 执行手机号约束验证流程；
 *
 * @author daffupman
 * @since 2020/1/31
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// 指定注解关联的验证器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

    /*
    约束注解验证时的输出信息
     */
    String message() default "请输入合法的手机号";

    /*
    约束注解在验证时所属的组别
     */
    Class<?>[] groups() default {};

    /*
    约束注解有效负载
     */
    Class<? extends Payload>[] payload() default {};
}
