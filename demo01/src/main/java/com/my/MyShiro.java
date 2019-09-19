package com.my;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/*
 *用户：sky-吴
 *日期：2019/8/27
 */
public class MyShiro {

	public static void main(String[] args) {

		// securityManager 相当于springMVC中的dispatcherServlet
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
		//认证器, 验证用户是否合法 策略是最少只有一个
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
		//把验证方式传给securityManager
		securityManager.setAuthenticator(authenticator);

		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();
		//授权器, 验证用户是否有权限
		authorizer.setPermissionResolver(new WildcardPermissionResolver());
		securityManager.setAuthorizer(authorizer);
		//配置数据源
		securityManager.setRealm(new MyRealm());
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("test", "123");
		try {

			subject.login(token);
			System.out.println("登陆成功");
		} catch (
				AuthenticationException e) {
			//e.printStackTrace();
			System.out.println("用户名或者密码错误");
		}
	}

}

/*
authorizer
n.
核准人；授权人


*/