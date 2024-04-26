/**
 * 
 */
package org.feng.service;

import java.util.List;

import org.feng.bean.JingFengTrip;
import org.feng.bean.Province;
import org.feng.bean.User;

/**
 * @author 姜峰
 *
 */
public interface JingFengTripService {

	/**
	 * @return
	 */
	List<Province> getAllCities();

	/**
	 * @param jft
	 * @return
	 */
	JingFengTrip addActivity(JingFengTrip jft);

	/**
	 * @return
	 */
	List<JingFengTrip> getAllJingFengTrips();

	/**
	 * @param userId
	 * @return
	 */
	List<JingFengTrip> getAllJingFengTripsByUser(Integer userId);

}
