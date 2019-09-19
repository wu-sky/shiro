package com.controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {



	@RequestMapping("goLogin.do")
	public String goLogin(){
		return "/common/login";
	}


	@RequestMapping("login.do")
	public String login(String username, String password,Model model){


		Subject subject= SecurityUtils.getSubject();
		String msg ="";
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		try {

			subject.login(token);
			System.out.println("login success");
			msg=username+", login success";
			model.addAttribute("msg", msg);
			return "/common/index";
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("login fail");
			msg="login fail";
			model.addAttribute("msg", msg);
			return "/common/login";
		}
	}

	@RequestMapping("logout.do")
	public String logout(Model model){
		Subject subject= SecurityUtils.getSubject();
		String msg ="用户正常退出";
		model.addAttribute("msg", msg);
		subject.logout();//把内存的session干掉, 即使不退出, 剩下的资源也访问不到HTTP ERROR 404
		return "/common/login";
	}

}

/*
 *用户：sky-吴
 *日期：2019/8/29
 */