/**
 * 
 */
package org.feng.service;

import org.feng.bean.JingFengTrip;
import org.feng.bean.Province;
import org.feng.dao.JingFengTripJpaSpecificationExecutor;
import org.feng.dao.ProvinceJpaSpecificationExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 姜峰
 *
 */
//@Service("jingFengTripService")
public class JingFengTripServiceImpl_old implements JingFengTripService {
	
	@Autowired
	private JingFengTripJpaSpecificationExecutor jingFengTripExecutor;

	@Autowired
	private ProvinceJpaSpecificationExecutor provinceExecutor;

	/* (non-Javadoc)
	 * @see org.feng.service.JingFengTripService#getAllCities()
	 */
	@Override
	public List<Province> getAllCities() {
		List<Province> provinces = provinceExecutor.findAll();
		List<Province> result = new ArrayList<>();
		for (Province province : provinces) {
			List<Province> childrenProvinces = new ArrayList<>();
			for (Province city : provinces) {
				if (province.getCodeid() == city.getParentid()) {
					childrenProvinces.add(city);
				}
			}
			province.setChildrenProvinces(childrenProvinces);
			if (province.getChildrenProvinces().size() > 0) {
				result.add(province);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.feng.service.JingFengTripService#addActivity(org.feng.bean.JingFengTrip)
	 */
	@Override
	public JingFengTrip addActivity(JingFengTrip jft) {
		return this.jingFengTripExecutor.save(jft);
	}

	/* (non-Javadoc)
	 * @see org.feng.service.JingFengTripService#getAllJingFengTrips()
	 */
	@Override
	public List<JingFengTrip> getAllJingFengTrips() {
		return this.jingFengTripExecutor.findAll();
	}

	/* (non-Javadoc)
	 * @see org.feng.service.JingFengTripService#getAllJingFengTripsByUser(java.lang.Integer)
	 */
	@Override
	public List<JingFengTrip> getAllJingFengTripsByUser(Integer userId) {
		Specification<JingFengTrip> spec = new Specification<JingFengTrip>() {
			
			@Override
			public Predicate toPredicate(Root<JingFengTrip> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("userId"), userId);
				return predicate;
			}
		};
		return this.jingFengTripExecutor.findAll(spec);
	}

}
