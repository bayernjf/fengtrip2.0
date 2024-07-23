/**
 * 
 */
package org.feng.dao;

import org.feng.bean.ProvincePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 姜峰
 *
 */
public interface ProvinceJpaSpecificationExecutor extends JpaRepository<ProvincePO, Integer>,
														JpaSpecificationExecutor<ProvincePO>{

}
