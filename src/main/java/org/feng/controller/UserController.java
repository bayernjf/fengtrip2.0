/**
 * 
 */
package org.feng.controller;

import javax.servlet.http.HttpServletRequest;

import org.feng.bean.UserPO;
import org.feng.dto.UserDTO;
import org.feng.dto.UserParameterDTO;
import org.feng.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author 姜峰
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public UserDTO login(@RequestBody UserParameterDTO userParameterDTO) {
		return userService.login(userParameterDTO);
	}

	@RequestMapping("/user/register.do")
	public String register(HttpServletRequest request, Model model,
			@RequestParam(name="username", required=true) String username,
			@RequestParam(name="password", required=true) String password) {
		
		return null;
		
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
		UserPO tempOfUserPO = (UserPO) request.getSession().getAttribute("tempOfUser");
		try {
			if (tempOfUserPO.getPassword().equals(password)) {
				request.getSession().setAttribute("user", tempOfUserPO);
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
