/**
 * 
 */
package org.feng.dao;

import org.feng.bean.JingFengTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 姜峰
 *
 */
public interface JingFengTripJpaSpecificationExecutor extends JpaRepository<JingFengTrip, Integer>,
														JpaSpecificationExecutor<JingFengTrip>{

}
