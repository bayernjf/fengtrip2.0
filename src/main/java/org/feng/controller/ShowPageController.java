/**
 * 
 */
package org.feng.controller;

import javax.servlet.http.HttpServletRequest;

import org.feng.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;

/**
 * @author 姜峰
 *
 */
@Controller
public class ShowPageController {

	@RequestMapping("/{page}")
	public String showPage(HttpServletRequest request,
			@PathVariable String page) {
		
		request.getSession().setAttribute("backtoindex", "no");
		
		return page;
	}
	
	@RequestMapping("/index.html")
	public String indexPage(HttpServletRequest request) {
		
		request.getSession().setAttribute("backtoindex", "yes");
		request.getSession().setAttribute("loginmsg", "");
		request.getSession().setAttribute("registermsg", "");
		
		return "index";
	}

	@RequestMapping("/login.html")
	public String loginPage(HttpServletRequest request) {
		
		request.getSession().setAttribute("registermsg", "");
		
		return "login";
	}

	@RequestMapping("/register.html")
	public String registerPage(HttpServletRequest request) {
		
		request.getSession().setAttribute("loginmsg", "");
		
		return "register";
	}

	@RequestMapping("/lock_screen.html")
	public String lockScreenPage(HttpServletRequest request) {
		
		User tempOfUser = (User) request.getSession().getAttribute("user");
		request.getSession().setAttribute("tempOfUser", tempOfUser);
		request.getSession().setAttribute("user", null);
//		System.out.println("tempOfUser : " + tempOfUser);
		return "lock_screen";
	}

}
