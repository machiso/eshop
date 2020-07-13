package com.zhss.eshop.membership.service;

import com.zhss.eshop.membership.domain.MemberLevelDetailDTO;
import com.zhss.eshop.membership.domain.MemberLevelDetailQuery;

import java.util.List;

/**
 * 会员等级明细管理service接口
 * @author zhonghuashishan
 *
 */
public interface MemberLevelDetailService {

	/**
	 * 分页查询会员等级变更明细 
	 * @param query 查询调价你
	 * @return 会员等级变更明细
	 * @throws Exception
	 */
	List<MemberLevelDetailDTO> listByPage(MemberLevelDetailQuery query) throws Exception;
	
}
