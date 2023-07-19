package org.warehouse.models.stdin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.warehouse.models.BaseEntity;

import java.time.LocalDate;
import java.util.List;

@Data
public class StdinTestForm extends BaseEntity {
	@NotNull
	private LocalDate stdinDt;
	@NotBlank
	private String clntCd;
	private String clntNm;

	private String status;


	/* item S */
	@NotBlank
	private List<String> itemCd;
	private List<String> itemNm;
	@NotBlank
	private List<String> locCd;

	private List<Long> beforeStdin;
	private List<Long> normal;
	private List<Long> fault;
	/* item E */

	private String flag;	// register, update 구분용
	private String stdinNum;
}
