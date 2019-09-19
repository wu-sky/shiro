package com.common;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "IndexServlet" , urlPatterns = "/index.do")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/common/index.jsp").forward(req, resp);
		}

}

/*surround with是把选中的代码块装进一些带有{}的语句中，比如if，try，for等等, 快捷键是ctrl+alt+t
 *用户：sky-吴
 *日期：2019/8/28
 */