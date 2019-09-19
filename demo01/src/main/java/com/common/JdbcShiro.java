package com.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class JdbcShiro{
	
	public static void main(String[] args){
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-mysql.ini");
		SecurityManager sercuManager=factory.getInstance();
		SecurityUtils.setSecurityManager(sercuManager);
		//subject:当前用户, 只有自己的行为和方法, 和securityManager交互
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("admin" , "123");
		try {
			subject.login(token);
			if (subject.isAuthenticated()){
				System.out.println(subject.isAuthenticated());
				System.out.println("登陆成功");

				if (subject.hasRole("admin")){
					System.out.println("拥有最高权限");
				}else{
					System.out.println("没有最高权限");
				}
				if (subject.isPermitted("delete")){
					System.out.println("有删除权限");
				}else{

					System.out.println("没有删除权限");
				}
				if (subject.isPermitted("select")){
					System.out.println("有查看权限");
				}else{

					System.out.println("没有查看权限");
				}
				if (subject.isPermittedAll(new String[]{"select", "add","update","delete"})){
					System.out.println("有所有权限");
				}else{
					System.out.println("没有所有权限");
				}
			}
		}catch (AuthenticationException e){
			//e.printStackTrace();
			System.out.println("用户名或者密码错误");
		}
	}
}

/*
 *用户：sky-吴
 *日期：2019/8/27
 * 智联
 * 南宁人才网
 * boss直聘
 * 拉勾网
 * 前程无忧
 * 脉脉
 */