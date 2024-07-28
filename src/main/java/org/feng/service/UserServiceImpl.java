/**
 * 
 */
package org.feng.service;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.feng.bean.UserPO;
import org.feng.dto.UserDTO;
import org.feng.dto.UserParameterDTO;
import org.feng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author 姜峰
 *
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDTO login(UserParameterDTO userParameterDTO) {
		HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
		UserDTO result = new UserDTO();
		UserPO one = userMapper.findOne(userParameterDTO);
		result.setUsername(one.getUsername());
		result.setPassword(one.getPassword());
		return result;
	}

	@Override
	public UserDTO register(UserParameterDTO userParameterDTO) {
		UserDTO result = new UserDTO();
		UserPO one = userMapper.findOneByUsername(userParameterDTO);
		if (one != null) {
			return null;
		}
		Boolean flag = userMapper.addOne(userParameterDTO);
		if (flag) {
			result.setUsername(userParameterDTO.getUsername());
			result.setPassword(userParameterDTO.getPassword());
			return result;
		}
		return null;
	}

}
