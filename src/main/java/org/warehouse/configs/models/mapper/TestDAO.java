package org.warehouse.configs.models.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.warehouse.models.admin.cust.CustCustCtrVO;

import java.util.List;

@Mapper
public interface TestDAO {
	List<CustCustCtrVO> getCustCustCtrList();
}
