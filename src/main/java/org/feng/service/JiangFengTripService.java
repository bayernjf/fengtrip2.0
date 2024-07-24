/**
 * 
 */
package org.feng.service;

import java.util.List;

import org.feng.bean.JiangFengTripPO;
import org.feng.bean.ProvincePO;

/**
 * @author 姜峰
 *
 */
public interface JiangFengTripService {

	List<ProvincePO> getAllCities();

	JiangFengTripPO addActivity(JiangFengTripPO jft);

	List<JiangFengTripPO> getAllJingFengTrips();

	List<JiangFengTripPO> getAllJingFengTripsByUser(Integer userId);

}
