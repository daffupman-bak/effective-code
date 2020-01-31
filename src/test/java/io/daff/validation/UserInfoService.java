package io.daff.validation;

import javax.validation.Valid;

/**
 * @author daffupman
 * @since 2020/1/31
 */
public class UserInfoService {

    /**
     * 默认构造校验
     */
    public UserInfoService() {}

    /**
     * 有参构造校验
     */
    public UserInfoService(@Valid UserInfo userInfo) {
    }

    /**
     * 入参校验
     */
    public void setUserInfo(@Valid UserInfo userInfo) { }

    /**
     * 出参校验
     */
    public @Valid UserInfo getUserInfo() {
        return new UserInfo();
    }
}
