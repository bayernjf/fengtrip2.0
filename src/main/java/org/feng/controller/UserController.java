/**
 * 
 */
package org.feng.controller;

import javax.servlet.http.HttpServletRequest;

import org.feng.bean.User;
import org.feng.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 姜峰
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping("/user/login.do")
	public String login(HttpServletRequest request, Model model,
			@RequestParam(name="username", required=true) String username,
			@RequestParam(name="password", required=true) String password) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User result = us.login(user);
		System.out.println("login========== result: " + result);
		if (result != null) {
			request.getSession().setAttribute("loginmsg", "");
			request.getSession().setAttribute("backtoindex", "yes");
			request.getSession().setAttribute("user", result);
			return "redirect:/index.html";
		} else {
//			model.addAttribute("loginmsg", "未找到用户，请检查用户名或密码");
			request.getSession().setAttribute("loginmsg", "未找到用户，请检查用户名或密码");
			return "redirect:/login.html";
		}
		
	}

	@RequestMapping("/user/register.do")
	public String register(HttpServletRequest request, Model model,
			@RequestParam(name="username", required=true) String username,
			@RequestParam(name="password", required=true) String password) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
//		User result = us.login(user);
		User result = us.register(user);
		if (result != null) {
			request.getSession().setAttribute("registermsg", "");
			request.getSession().setAttribute("backtoindex", "yes");
			return "redirect:/login.html";
		} else {
			request.getSession().setAttribute("registermsg", "注册失败，请检查用户名或密码");
			return "redirect:/register.html";
		}
		
	}

	@RequestMapping("/user/logout.do")
	public String logout(HttpServletRequest request, Model model) {
		
		request.getSession().setAttribute("user", null);
		return "redirect:/index.html";
		
	}

	@RequestMapping("/user/lockScreen.do")
	@ResponseBody
	public String lockScreen(HttpServletRequest request, Model model,
			@RequestParam(name="password", required=true) String password) {
		
		JSONObject jobj = new JSONObject();
		User tempOfUser = (User) request.getSession().getAttribute("tempOfUser");
		try {
			if (tempOfUser.getPassword().equals(password)) {
				request.getSession().setAttribute("user", tempOfUser);
				jobj.put("code", 1);
				jobj.put("msg", "/index.html");
			} else {
				request.getSession().setAttribute("user", null);
				jobj.put("code", -1);
				jobj.put("msg", "密码错误");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "redirect:/index.html";
		return jobj.toString();
		
	}

}
