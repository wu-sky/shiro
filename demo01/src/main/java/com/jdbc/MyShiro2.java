package com.jdbc;

import com.my.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/*
 *用户：sky-吴
 *日期：2019/8/27
 */
public class MyShiro2 {

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
		/*
		* # dataSource.driverClassName 中的.是对象的setter方法赋值
dataSource.driverClassName=com.mysql.jdbc.Driver
dataSource.url=jdbc:mysql://localhost:3306/db1902
dataSource.username=u1902
dataSource.password=u1902*/
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db1902");
		dataSource.setUsername("u1902");
		dataSource.setPassword("u1902");
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		MyRealm2 myRealm2=new MyRealm2();
		myRealm2.setJdbcTemplate(jdbcTemplate);
		System.out.println("jdbcTemplate: "+myRealm2.getJdbcTemplate());
		securityManager.setRealm(myRealm2);
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
		try {

			subject.login(token);
			System.out.println("has admin ?? " + subject.hasRole("admin"));
			System.out.println("登陆成功");
		} catch (
				AuthenticationException e) {
			e.printStackTrace();
			System.out.println("用户名或者密码错误");
		}
	}

}

/*
authorizer
n.
核准人；授权人


*/