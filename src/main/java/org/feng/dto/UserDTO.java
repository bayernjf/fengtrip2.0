package org.feng.dto;

import lombok.Data;
import org.feng.bean.JiangFengTripPO;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangfeng-20240725
 * @time 2024-07-25 00:26
 */
@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private Set<JiangFengTripPO> jiangFengTripPOS = new HashSet<>();

}
