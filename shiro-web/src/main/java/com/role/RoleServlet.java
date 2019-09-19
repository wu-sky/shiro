package com.role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RoleServlet" , urlPatterns = "/role.do")
public class RoleServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String msg="";
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/role/list.jsp").forward(req, resp);


	}
}
/*
 *用户：sky-吴
 *日期：2019/8/28
 */