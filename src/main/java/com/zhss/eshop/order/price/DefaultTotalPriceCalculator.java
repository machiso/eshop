package com.zhss.eshop.order.price;

import com.zhss.eshop.order.domain.OrderItemDTO;
import org.springframework.stereotype.Component;

/**
 * 总金额默认计算器
 * @author zhonghuashishan
 *
 */
@Component
public class DefaultTotalPriceCalculator implements TotalPriceCalculator {
	
	/**
	 * 计算商品的总金额
	 */
	@Override
	public Double calculate(OrderItemDTO item) {
		return item.getPurchasePrice() * item.getPurchaseQuantity();  
	}
	
}
