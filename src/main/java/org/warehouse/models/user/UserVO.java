package org.warehouse.models.user;

import lombok.Data;

import org.warehouse.commons.constraints.Role;
import org.warehouse.models.BaseEntity;

@Data
public class UserVO extends BaseEntity {
	private String userId;
	private String userPw;

	private String userNm;
	private Role userType;
	private String clntCd;
	private String custCtrCd;
	private String custCd;
	private String position;
	private String tel;
	private String email;
}
