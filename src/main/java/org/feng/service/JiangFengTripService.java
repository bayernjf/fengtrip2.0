/**
 * 
 */
package org.feng.service;

import java.util.List;

import org.feng.bean.JiangFengTrip;
import org.feng.bean.ProvincePO;

/**
 * @author 姜峰
 *
 */
public interface JiangFengTripService {

	/**
	 * @return
	 */
	List<ProvincePO> getAllCities();

	/**
	 * @param jft
	 * @return
	 */
	JiangFengTrip addActivity(JiangFengTrip jft);

	/**
	 * @return
	 */
	List<JiangFengTrip> getAllJingFengTrips();

	/**
	 * @param userId
	 * @return
	 */
	List<JiangFengTrip> getAllJingFengTripsByUser(Integer userId);

}
