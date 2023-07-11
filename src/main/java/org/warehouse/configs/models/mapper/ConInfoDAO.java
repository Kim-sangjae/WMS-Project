package org.warehouse.configs.models.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.warehouse.models.baseinfo.coninfo.ConInfoVO;

import java.util.List;

@Mapper
public interface ConInfoDAO {

	void insertConInfo(ConInfoVO conInfo); // 계약정보

	ConInfoVO getClntCd();					// 고객사 코드

	ConInfoVO getTranSdt();

	List<ConInfoVO> getConListSearch(ConInfoVO srchParam);

	void deleteConInfo(String deleteVal);	// 	삭제여부 갱신
}