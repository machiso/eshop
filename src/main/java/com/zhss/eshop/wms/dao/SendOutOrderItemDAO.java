package com.zhss.eshop.wms.dao;

import com.zhss.eshop.wms.domain.SendOutOrderItemDO;

import java.util.List;

/**
 * 发货单条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface SendOutOrderItemDAO {

	/**
	 * 新增发货单条目
	 * @param sendOutOrderItem 发货单条目
	 * @throws Exception
	 */
	void save(SendOutOrderItemDO sendOutOrderItem) throws Exception;
	
	/**
	 * 查询发货单条目
	 * @param sendOutOrderId 发货单id
	 * @return 发货单条目
	 * @throws Exception
	 */
	List<SendOutOrderItemDO> listByOrderInfoId(Long sendOutOrderId) throws Exception;
	
}
