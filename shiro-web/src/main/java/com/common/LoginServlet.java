package com.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
 *用户：sky-吴
 *日期：2019/8/28
 */
@WebServlet(name = "loginServlet" , urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username=req.getParameter("username");
		String password=req.getParameter("password");
		Subject subject= SecurityUtils.getSubject();
		String msg ="";
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		try {

			subject.login(token);
			System.out.println("login success");
			msg=username+", login success";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/index.do").forward(req, resp);

		}catch (Exception e){
			e.printStackTrace();
			System.out.println("login fail");
			msg="login fail";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/common/login.jsp").forward(req, resp);
		}





	}
}
