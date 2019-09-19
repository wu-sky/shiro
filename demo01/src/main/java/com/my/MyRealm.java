package com.my;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * realm 相当于数据源, 为securityManager 提供需要验证的用户
 */
public class MyRealm implements Realm {
	public String getName() {

		return "myRealm";
	}

	public boolean supports(AuthenticationToken authenticationToken) {
		//限制数据源只支持UsernamePasswordToken
		return authenticationToken instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username= (String) authenticationToken.getPrincipal();
		String password= new String(( char []) authenticationToken.getCredentials());
		if (!"test".equals(username)){
			throw new UnknownAccountException();
		}
		if (!"123".equals(password)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(username, password, getName());
	}
}
/*
 *用户：sky-吴
 *日期：2019/8/27
 */