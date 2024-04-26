/**
 * 
 */
package org.feng.dao;

import org.feng.bean.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 姜峰
 *
 */
public interface ProvinceJpaSpecificationExecutor extends JpaRepository<Province, Integer>,
														JpaSpecificationExecutor<Province>{

}
