/**
 * 
 */
package org.feng.dao;

import org.feng.bean.JiangFengTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 姜峰
 *
 */
public interface JiangFengTripJpaSpecificationExecutor extends JpaRepository<JiangFengTrip, Integer>,
														JpaSpecificationExecutor<JiangFengTrip>{

}
