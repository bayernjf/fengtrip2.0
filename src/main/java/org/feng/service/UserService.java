/**
 * 
 */
package org.feng.service;

import org.feng.bean.User;

/**
 * @author 姜峰
 *
 */
public interface UserService {

	/**
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * @param user
	 * @return
	 */
	User register(User user);

}
