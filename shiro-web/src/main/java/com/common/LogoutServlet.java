package com.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "logoutServlet" , urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Subject subject= SecurityUtils.getSubject();
		String msg ="用户正常退出";
		req.setAttribute("msg", msg);
		subject.logout();//把内存的session干掉, 即使不退出, 剩下的资源也访问不到HTTP ERROR 404
		req.getRequestDispatcher("/common/login.jsp").forward(req, resp);
	}
}

/*
 *用户：sky-吴
 *日期：2019/8/28
 */