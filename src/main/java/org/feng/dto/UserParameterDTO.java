package org.feng.dto;

import lombok.Data;
import org.feng.bean.JiangFengTripPO;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangfeng-20240725
 * @time 2024-07-25 00:28
 */
@Data
public class UserParameterDTO {

    private Integer id;

    private String username;

    private String password;

    private Set<JiangFengTripPO> jiangFengTripPOS = new HashSet<>();

}
