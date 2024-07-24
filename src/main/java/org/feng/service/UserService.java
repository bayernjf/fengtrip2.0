/**
 * 
 */
package org.feng.service;

import org.feng.bean.UserPO;
import org.feng.dto.UserDTO;
import org.feng.dto.UserParameterDTO;

/**
 * @author 姜峰
 *
 */
public interface UserService {

	/**
	 * @param userParameterDTO
	 * @return
	 */
	UserDTO login(UserParameterDTO userParameterDTO);

	/**
	 * @param userPO
	 * @return
	 */
	UserDTO register(UserParameterDTO userParameterDTO);

}
