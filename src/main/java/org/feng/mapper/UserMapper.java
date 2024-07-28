package org.feng.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.feng.bean.UserPO;
import org.feng.dto.UserParameterDTO;

@Mapper
public interface UserMapper {

    UserPO findOne(UserParameterDTO userParameterDTO);

    Boolean addOne(UserParameterDTO userParameterDTO);

    UserPO findOneByUsername(UserParameterDTO userParameterDTO);
}
