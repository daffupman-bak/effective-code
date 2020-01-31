package io.daff.validation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Set;

/**
 * 验证测试类
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class ValidationTest {

    /**
     * 验证器对象
     */
    private Validator validator;
    /**
     * 待验证对象
     */
    private UserInfo userInfo;
    /**
     * 验证结果集合
     */
    private Set<ConstraintViolation<UserInfo>> set;
    /**
     * 验证结果集合
     */
    private Set<ConstraintViolation<UserInfoService>> serviceSet;

    @Before
    public void init() {
        // 初始化验证器
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        // 初始化待验证对象
        userInfo = new UserInfo();
//        userInfo.setUserId("1");
        userInfo.setUsername("wang");
        userInfo.setPassword("123456");
        userInfo.setEmail("shit@fuck.cn");
        userInfo.setAge(25);
        userInfo.setPhone("15895858185");
        Calendar instance = Calendar.getInstance();
        instance.set(2019, Calendar.OCTOBER, 1);
        userInfo.setBirthday(instance.getTime());
        ArrayList<UserInfo> friends = new ArrayList<>();
        UserInfo friend1 = new UserInfo();
        friend1.setUserId("2");
        friend1.setUsername("好友01");
        friend1.setPassword("654321");
        friend1.setPhone("15895858186");
        friends.add(friend1);

        this.userInfo.setFriends(friends);
    }

    @After
    public void print() {
        if (set != null) {
            set.forEach(item -> {
                System.out.println(item.getMessage());
            });
        }
        if (serviceSet != null) {
            serviceSet.forEach(item -> {
                System.out.println(item.getMessage());
            });
        }
    }

    @Test
    public void nullValidation() {
        set = validator.validate(userInfo);
    }

    /**
     * 级联验证
     */
    @Test
    public void graphValidation() {
        set = validator.validate(userInfo);
    }

    /**
     * 分组验证
     */
    @Test
    public void groupValidation() {
        set = validator.validate(userInfo, UserInfo.LoginGroup.class);
    }

    /**
     * 组排序
     */
    @Test
    public void groupSequenceValidation() {
        set = validator.validate(userInfo, UserInfo.Group.class);
    }

    /**
     * 方法入参校验
     */
    @Test
    public void paramValidation() throws NoSuchMethodException {
        // 获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        // 待验证对象
        UserInfoService service = new UserInfoService();
        // 待验证方法
        Method method = service.getClass()
                .getMethod("setUserInfo", UserInfo.class);
        // 方法入参
        Object[] paramObjects = new Object[]{new UserInfo()};

        // 对入参进行校验
        serviceSet = executableValidator.validateParameters(
                service,
                method,
                paramObjects
        );
    }

    /**
     * 对方法返回值进行约束校验
     */
    @Test
    public void returnValueValidation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取校验执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        // 构造要验证的方法对象
        UserInfoService service = new UserInfoService();
        Method method = service.getClass().getMethod("getUserInfo");

        // 调用方法获取返回值
        Object ret = method.invoke(service);

        // 校验方法返回值是否符合约束
        serviceSet = executableValidator.validateReturnValue(
                service,
                method,
                ret
        );
    }

    /**
     * 构造函数入参校验
     */
    @Test
    public void constructorValidation() throws NoSuchMethodException {
        // 获取验证执行器
        ExecutableValidator executableValidator = validator.forExecutables();

        // 获取构造函数
        Constructor<UserInfoService> constructor =
                UserInfoService.class
                        .getConstructor(UserInfo.class);
        Object[] paramObjects = {new UserInfo()};

        // 校验构造函数
        serviceSet = executableValidator.validateConstructorParameters(
                constructor,
                paramObjects
        );
    }
}
