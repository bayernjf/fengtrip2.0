/**
 * 
 */
package org.feng.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.catalina.User;
import org.feng.bean.UserPO;
import org.feng.dto.UserDTO;
import org.feng.dto.UserParameterDTO;
import org.feng.mapper.UserMapper;
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
	private UserMapper userMapper;

	@Override
	public UserDTO login(UserParameterDTO userParameterDTO) {
		UserDTO result = new UserDTO();
		UserPO one = userMapper.findOne(userParameterDTO);
		result.setUsername(one.getUsername());
		result.setPassword(one.getPassword());
		return result;
	}

	@Override
	public UserDTO register(UserParameterDTO userParameterDTO) {
		return null;
	}

}
