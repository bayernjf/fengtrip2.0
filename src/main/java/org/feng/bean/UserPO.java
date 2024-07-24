/**
 * 
 */
package org.feng.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 姜峰
 *
 */
@Data
public class UserPO implements Serializable {

	private Integer id;

	private String username;

	private String password;

	private Set<JiangFengTripPO> jiangFengTripPOS = new HashSet<>();

}
