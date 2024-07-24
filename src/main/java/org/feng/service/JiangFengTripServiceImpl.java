/**
 * 
 */
package org.feng.service;

import java.util.List;

import org.feng.bean.JiangFengTripPO;
import org.feng.bean.ProvincePO;
import org.springframework.stereotype.Service;

/**
 * @author 姜峰
 *
 */
@Service("jingFengTripService")
public class JiangFengTripServiceImpl implements JiangFengTripService {
	@Override
	public List<ProvincePO> getAllCities() {
		return null;
	}

	@Override
	public JiangFengTripPO addActivity(JiangFengTripPO jft) {
		return null;
	}

	@Override
	public List<JiangFengTripPO> getAllJingFengTrips() {
		return null;
	}

	@Override
	public List<JiangFengTripPO> getAllJingFengTripsByUser(Integer userId) {
		return null;
	}

//	@Override
//	public List<ProvincePO> getAllCities() {
//		List<ProvincePO> provincePOS = provinceExecutor.findAll();
//		List<ProvincePO> result = new ArrayList<>();
//		for (ProvincePO provincePO : provincePOS) {
//			List<ProvincePO> childrenProvincePOS = new ArrayList<>();
//			for (ProvincePO city : provincePOS) {
//				if (provincePO.getCodeid() == city.getParentid()) {
//					childrenProvincePOS.add(city);
//				}
//			}
//			provincePO.setChildrenProvinces(childrenProvincePOS);
//			if (provincePO.getChildrenProvinces().size() > 0) {
//				result.add(provincePO);
//			}
//		}
//		return result;
//	}


}
