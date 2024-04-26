/**
 * 
 */
package org.feng.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.feng.bean.JingFengTrip;
import org.feng.bean.Province;
import org.feng.bean.User;
import org.feng.service.JingFengTripService;
import org.json.JSONException;
import com.alibaba.fastjson.JSONObject;
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
public class JingFengTripController {

	@Autowired
	private JingFengTripService jfts;
	
	@RequestMapping("/jingfengtrip/getAllCities.do")
	@ResponseBody
	private String getCities() {
		JSONObject jobj = new JSONObject();
		List<Province> provinces = jfts.getAllCities();
		if (provinces != null && provinces.size() > 0) {
			jobj.put("code", 1);
			jobj.put("msg", provinces);
		} else {
			jobj.put("code", -1);
			jobj.put("msg", "数据获取失败");
		}
		int count = 0;
		for (Province province : provinces) {
//			if (province.getChildrenProvinces().size() > 0) {
//				count += 1;
//				System.out.println("=========== province: " + province);
//			}
			count += 1;
			System.out.println("=========== province: " + province);
		}
		System.out.println("=========== size: " + count);
		
		return jobj.toString();
	}
	
	@RequestMapping("/jingfengtrip/addActivity.do")
	public String addActivity(HttpServletRequest request,
			@RequestParam(name="location", required=true) String location,
			@RequestParam(name="activity", required=true) String activity,
			@RequestParam(name="transportation", required=true) String transportation,
			@RequestParam(name="time", required=true) String time,
			@RequestParam(name="priority", required=true) Integer priority,
			@RequestParam(name="fengcity", required=true) String city) {
		
//		System.out.println("========= location: " + location);
//		System.out.println("========= activity: " + activity);
//		System.out.println("========= transportation: " + transportation);
//		System.out.println("========= time: " + time);
//		System.out.println("========= priority: " + priority);
//		System.out.println("========= city: " + city);
		
		JingFengTrip jft = new JingFengTrip();
		jft.setLocation(location);
		jft.setActivity(activity);
		jft.setTransportation(transportation);
		jft.setTime(time);
		jft.setPriority(priority);
		jft.setCity(city);
		jft.setCreateTime(new Date());
		User user = (User) request.getSession().getAttribute("user");
		jft.setUserId(user.getId());
		jft.setStat(0);
		
		jft.setLocation(city + " " + location);
		
		System.out.println("===========jft : " + jft);
		
		this.jfts.addActivity(jft);
		
		return "redirect:/addActivities.html";
	}
	
	@RequestMapping("/userHome.html")
	public String userHomePage(HttpServletRequest request, Model model) {
		
//		List<JingFengTrip> jingfengtrips = this.jfts.getAllJingFengTrips();
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		List<JingFengTrip> jingfengtrips = this.jfts.getAllJingFengTripsByUser(userId);
		model.addAttribute("jingfengtrips", jingfengtrips);
		
		return "userHome";
	}

}
