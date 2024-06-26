/**
 * 
 */
package org.feng.dao;

import org.feng.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 姜峰
 *
 */
public interface UserJpaSpecificationExecutor extends JpaRepository<User, Integer>,
														JpaSpecificationExecutor<User>{

}
