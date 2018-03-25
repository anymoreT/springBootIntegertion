package com.hdw.springboot.security;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by xinshu on 2016/4/11.
 */
public class ShiroRealmImpl extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(ShiroRealmImpl.class);

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();
        String encodedPassword = new Sha256Hash(usernamePasswordToken.getPassword()).toBase64();

        logger.info("------------------------authentication--------------------------");


        if (false) {
            // TODO 用户名不存在
            throw new UnknownAccountException();

        } else if (false) {
            // TODO 密码错误
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(new ShiroUser("用户id", "用户编码", "用户名称"),
                String.valueOf(usernamePasswordToken.getPassword()),
                ByteSource.Util.bytes("用户id"), getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
        String userName = shiroUser.getName();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // TODO
        if (StringUtils.equals("admin", userName)) {
            info.addRole("admin");
            info.addStringPermission("user:edit");

        } else if (StringUtils.equals("test", userName)) {
            info.addRole("test");
            info.addStringPermission("user:view");
        } else {
            return null;
        }

        return info;
    }


    public static class ShiroUser implements Serializable {

        public String id;
        public String number;
        public String name;

        public ShiroUser(String userId, String number, String name) {
            this.id = userId;
            this.name = name;
            this.number = number;
        }

        public ShiroUser(String number, String name) {
            this.number = number;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return number;
        }

    }

}