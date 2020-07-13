package com.zhss.eshop.wms.service.impl;

import com.zhss.eshop.wms.constant.PurchaseInputOrderStatus;
import com.zhss.eshop.wms.dao.PurchaseInputOrderDAO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 更新采购入库单状态的handler
 * @author zhonghuashishan
 *
 */
@Component
public class UpdatePurchaseInputOrderStatusHandler extends AbstractPurchaseInputOrderHandler {
	
	/**
	 * 采购入库单管理DAO组件
	 */
	@Autowired
	private PurchaseInputOrderDAO purchaseInputOrderDAO;
	
	/**
	 * 执行处理逻辑
	 * @param purchaseInputOrder 采购入库单
	 * @return 处理结果
	 * @throws Exception
	 */
	@Override
	public PurchaseInputOrderHandlerResult doExecute(
			PurchaseInputOrderDTO purchaseInputOrder) throws Exception {
		purchaseInputOrderDAO.updateStatus(purchaseInputOrder.getId(),
				PurchaseInputOrderStatus.FINISH_INPUT);
		return new PurchaseInputOrderHandlerResult(true);  
	}
	
}
