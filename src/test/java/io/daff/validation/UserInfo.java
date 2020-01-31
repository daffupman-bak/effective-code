package io.daff.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 校验框架demo：待验证对象实体类
 *
 * @author daffupman
 * @since 2020/1/31
 */
@Getter
@Setter
public class UserInfo {

    /**
     * 用户id
     */
    @NotNull(
            message = "用户id不能为空",
            groups = LoginGroup.class
    )
    private String userId;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名称不能为空")
    private String username;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度为6~20位。")
    private String password;

    /**
     * 邮箱
     */
    @NotNull(
            message = "邮箱不能为空",
            groups = RegisterGroup.class
    )
    @Email(message = "请输入合法的邮箱地址")
    private String email;

    /**
     * 手机号
     */
    @Phone(message = "手机号需要以158开头")
    private String phone;

    /**
     * 年龄
     */
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 60, message = "年龄不能大于60岁")
    private Integer age;

    /**
     * 生日
     */
    @Past(message = "生日不能是未来的时间")
    private Date birthday;

    /**
     * 好友列表
     */
    @Size(min = 1, message = "不能少于1个好友")
    private List<@Valid UserInfo> friends;

    /**
     * 登录场景
     */
    public interface LoginGroup { }

    /**
     * 注册场景
     */
    public interface RegisterGroup { }

    /**
     * 组排序
     * 先验证登录组，再验证注册组
     */
    @GroupSequence({
            LoginGroup.class,
            RegisterGroup.class,
            Default.class
    })
    public interface Group { }
}
