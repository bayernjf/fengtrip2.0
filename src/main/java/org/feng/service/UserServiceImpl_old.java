/**
 * 
 */
package org.feng.service;

import org.feng.bean.UserPO;
import org.feng.dao.UserJpaSpecificationExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author 姜峰
 *
 */
//@Service("userService")
public class UserServiceImpl_old implements UserService {
	
	@Autowired
	private UserJpaSpecificationExecutor executor;

	/* (non-Javadoc)
	 * @see org.feng.service.UserService#login(org.feng.bean.UserPO)
	 */
	@Override
	public UserPO login(UserPO userPO) {
		Specification<UserPO> spec = new Specification<UserPO>() {
			
			@Override
			public Predicate toPredicate(Root<UserPO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.and(
							cb.equal(root.get("username"), userPO.getUsername()),
							cb.equal(root.get("password"), userPO.getPassword())
						);
				return predicate;
			}
		};
		return executor.findOne(spec);
	}

	/* (non-Javadoc)
	 * @see org.feng.service.UserService#register(org.feng.bean.UserPO)
	 */
	@Override
	public UserPO register(UserPO userPO) {
		return executor.save(userPO);
	}

}
