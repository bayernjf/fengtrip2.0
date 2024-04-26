/**
 * 
 */
package org.feng.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.feng.bean.User;
import org.feng.dao.UserJpaSpecificationExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @author 姜峰
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserJpaSpecificationExecutor executor;

	/* (non-Javadoc)
	 * @see org.feng.service.UserService#login(org.feng.bean.User)
	 */
	@Override
	public User login(User user) {
		Specification<User> spec = new Specification<User>() {
			
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.and(
							cb.equal(root.get("username"), user.getUsername()),
							cb.equal(root.get("password"), user.getPassword())
						);
				return predicate;
			}
		};
		return executor.findOne(spec);
	}

	/* (non-Javadoc)
	 * @see org.feng.service.UserService#register(org.feng.bean.User)
	 */
	@Override
	public User register(User user) {
		return executor.save(user);
	}

}
