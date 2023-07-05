package org.warehouse.models.admin.clnt;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.warehouse.models.BaseEntity;

@Data
public class ClntForm extends BaseEntity {
	@NotBlank
	private String clntCd;
	@NotBlank
	private String clntNm;

	private String salesNm;
	private String salesTel;

	private String tplNm;
	private String tplTel;
	private String tplEmail;

	private String business;
	private String event;
	private String busiNum;

	private String ownerNm;
	private String ownerTel;

	private String busiAddr;

	private String flag;
}