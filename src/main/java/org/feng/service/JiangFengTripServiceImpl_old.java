/**
 * 
 */
package org.feng.service;

import org.feng.bean.JiangFengTrip;
import org.feng.bean.ProvincePO;
import org.feng.dao.JiangFengTripJpaSpecificationExecutor;
import org.feng.dao.ProvinceJpaSpecificationExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

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
public class JiangFengTripServiceImpl_old implements JiangFengTripService {
	
	@Autowired
	private JiangFengTripJpaSpecificationExecutor jingFengTripExecutor;

	@Autowired
	private ProvinceJpaSpecificationExecutor provinceExecutor;

	/* (non-Javadoc)
	 * @see org.feng.service.JiangFengTripService#getAllCities()
	 */
	@Override
	public List<ProvincePO> getAllCities() {
		List<ProvincePO> provincePOS = provinceExecutor.findAll();
		List<ProvincePO> result = new ArrayList<>();
		for (ProvincePO provincePO : provincePOS) {
			List<ProvincePO> childrenProvincePOS = new ArrayList<>();
			for (ProvincePO city : provincePOS) {
				if (provincePO.getCodeid() == city.getParentid()) {
					childrenProvincePOS.add(city);
				}
			}
			provincePO.setChildrenProvinces(childrenProvincePOS);
			if (provincePO.getChildrenProvinces().size() > 0) {
				result.add(provincePO);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.feng.service.JiangFengTripService#addActivity(org.feng.bean.JiangFengTrip)
	 */
	@Override
	public JiangFengTrip addActivity(JiangFengTrip jft) {
		return this.jingFengTripExecutor.save(jft);
	}

	/* (non-Javadoc)
	 * @see org.feng.service.JiangFengTripService#getAllJingFengTrips()
	 */
	@Override
	public List<JiangFengTrip> getAllJingFengTrips() {
		return this.jingFengTripExecutor.findAll();
	}

	/* (non-Javadoc)
	 * @see org.feng.service.JiangFengTripService#getAllJingFengTripsByUser(java.lang.Integer)
	 */
	@Override
	public List<JiangFengTrip> getAllJingFengTripsByUser(Integer userId) {
		Specification<JiangFengTrip> spec = new Specification<JiangFengTrip>() {
			
			@Override
			public Predicate toPredicate(Root<JiangFengTrip> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.equal(root.get("userId"), userId);
				return predicate;
			}
		};
		return this.jingFengTripExecutor.findAll(spec);
	}

}
