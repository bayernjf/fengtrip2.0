/**
 * 
 */
package org.feng.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.feng.bean.JiangFengTrip;
import org.feng.bean.ProvincePO;
import org.feng.bean.UserPO;
import org.feng.service.JiangFengTripService;
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
public class JiangFengTripController {

	@Autowired
	private JiangFengTripService jfts;
	
	@RequestMapping("/jiangfengtrip/getAllCities.do")
	@ResponseBody
	private String getCities() {
		JSONObject jobj = new JSONObject();
		List<ProvincePO> provincePOS = jfts.getAllCities();
		if (provincePOS != null && provincePOS.size() > 0) {
			jobj.put("code", 1);
			jobj.put("msg", provincePOS);
		} else {
			jobj.put("code", -1);
			jobj.put("msg", "数据获取失败");
		}
		int count = 0;
		for (ProvincePO provincePO : provincePOS) {
//			if (provincePO.getChildrenProvinces().size() > 0) {
//				count += 1;
//				System.out.println("=========== provincePO: " + provincePO);
//			}
			count += 1;
			System.out.println("=========== provincePO: " + provincePO);
		}
		System.out.println("=========== size: " + count);
		
		return jobj.toString();
	}
	
	@RequestMapping("/jiangfengtrip/addActivity.do")
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
		
		JiangFengTrip jft = new JiangFengTrip();
		jft.setLocation(location);
		jft.setActivity(activity);
		jft.setTransportation(transportation);
		jft.setTime(time);
		jft.setPriority(priority);
		jft.setCity(city);
		jft.setCreateTime(new Date());
		UserPO userPO = (UserPO) request.getSession().getAttribute("user");
		jft.setUserId(userPO.getId());
		jft.setStat(0);
		
		jft.setLocation(city + " " + location);
		
		System.out.println("===========jft : " + jft);
		
		this.jfts.addActivity(jft);
		
		return "redirect:/addActivities.html";
	}
	
	@RequestMapping("/userHome.html")
	public String userHomePage(HttpServletRequest request, Model model) {
		
//		List<JiangFengTrip> jingfengtrips = this.jfts.getAllJingFengTrips();
		UserPO userPO = (UserPO) request.getSession().getAttribute("user");
		Integer userId = userPO.getId();
		List<JiangFengTrip> jingfengtrips = this.jfts.getAllJingFengTripsByUser(userId);
		model.addAttribute("jingfengtrips", jingfengtrips);
		
		return "userHome";
	}

}
