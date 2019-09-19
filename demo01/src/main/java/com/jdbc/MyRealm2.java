package com.jdbc;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 不适用ini配置文件
 */
public class MyRealm2 extends AuthorizingRealm {
	private JdbcTemplate jdbcTemplate;
	//验证权限的时候调用
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("权限验证");
		String sql="select role_name from shiro_user_role where username=? ";
		String username=(String) principalCollection.getPrimaryPrincipal();
		List<String> roles=jdbcTemplate.queryForList(sql, String.class, username);
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		info.addRoles(roles);
		return info;
	}
	//登陆的时候调用
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		System.out.println("call doGetAuthenticationInfo");
		String sql="select password from shiro_user where username=?";
		String username=(String) authenticationToken.getPrincipal();
		//使用jdbc模板去查用户出来
		String password=jdbcTemplate.queryForObject(sql, String.class , username);
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username, password , null, getName());
		return info;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
/*
 *用户：sky-吴
 *日期：2019/8/28
 */