/**
 * 
 */
package org.feng.controller;

import org.feng.dto.UserDTO;
import org.feng.dto.UserParameterDTO;
import org.feng.service.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
		UserDTO result = userService.login(userParameterDTO);
		return result;
	}

	@PostMapping("/register")
	public UserDTO register(@RequestBody  UserParameterDTO userParameterDTO) {
		return userService.register(userParameterDTO);
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		// TODO jiangfeng-20240729 使用JWT实现跨域认证，存登录信息。
		request.getSession().setAttribute("user", null);
		return "/api/index.html";
	}

	@GetMapping("lockScreen")
	public String lockScreen(@RequestParam(name="password", required=true) String password) {
		JSONObject jobj = new JSONObject();
		try {
			jobj.put("code", 1);
			jobj.put("msg", "/api/index.html");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jobj.toString();
	}

}
