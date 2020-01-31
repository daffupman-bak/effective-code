package io.daff.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号验证约束注解关联验证器
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * 手机号逻辑校验方法
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 手机号的正则表达式
        String regPattern = "158\\d{8}";
        Pattern reg = Pattern.compile(regPattern);
        String phone = Optional.ofNullable(value).orElse("");
        Matcher matcher = reg.matcher(phone);
        return matcher.matches();
    }
}
