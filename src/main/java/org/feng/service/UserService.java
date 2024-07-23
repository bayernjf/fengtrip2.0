/**
 * 
 */
package org.feng.service;

import org.feng.bean.UserPO;

/**
 * @author 姜峰
 *
 */
public interface UserService {

	/**
	 * @param userPO
	 * @return
	 */
	UserPO login(UserPO userPO);

	/**
	 * @param userPO
	 * @return
	 */
	UserPO register(UserPO userPO);

}
