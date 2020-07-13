package com.zhss.eshop.finance.dao;

import com.zhss.eshop.finance.domain.PurchaseSettlementOrderItemDO;

import java.util.List;

/**
 * 采购结算单条目管理DAO接口
 * @author zhonghuashishan
 *
 */
public interface PurchaseSettlementOrderItemDAO {

	/**
	 * 批量新增采购结算单条目
	 * @param purchaseSettlementOrderId 采购结算单id
	 * @param purchaseSettlementOrderItems 采购结算单条目
	 * @throws Exception
	 */
	void batchSave(Long purchaseSettlementOrderId,
                   List<PurchaseSettlementOrderItemDO> purchaseSettlementOrderItems) throws Exception;

	/**
	 * 根据采购结算单id查询采购结算单条目
	 * @param purchaseSettlementOrderId 采购结算单id
	 * @return 采购结算单条目
	 * @throws Exception
	 */
	List<PurchaseSettlementOrderItemDO> listByPurchaseSettlementOrderId(
            Long purchaseSettlementOrderId) throws Exception;
	
}
