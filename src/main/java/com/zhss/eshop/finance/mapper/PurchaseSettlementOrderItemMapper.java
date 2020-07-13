package com.zhss.eshop.finance.mapper;

import com.zhss.eshop.finance.domain.PurchaseSettlementOrderItemDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 采购结算单条目管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface PurchaseSettlementOrderItemMapper {

	/**
	 * 新增采购结算单条目
	 * @param purchaseSettlementOrderItem 采购结算单条目
	 * @throws Exception
	 */
	@Insert("INSERT INTO finance_purchase_settlement_order_item("
				+ "purchase_settlement_order_id,"
				+ "goods_sku_id,"
				+ "purchase_count,"
				+ "purchase_price,"
				+ "qualified_count,"
				+ "arrival_count,"  
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{purchaseSettlementOrderId},"
				+ "#{goodsSkuId},"
				+ "#{purchaseCount},"
				+ "#{purchasePrice},"
				+ "#{qualifiedCount},"
				+ "#{arrivalCount},"  
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(PurchaseSettlementOrderItemDO purchaseSettlementOrderItem);
	
	/**
	 * 根据采购结算单id查询采购结算单条目
	 * @param purchaseSettlementOrderId 采购结算单id
	 * @return 采购结算单条目
	 */
	@Select("SELECT "
				+ "id,"
				+ "purchase_settlement_order_id,"
				+ "goods_sku_id,"
				+ "purchase_count,"
				+ "purchase_price,"
				+ "qualified_count,"
				+ "arrival_count,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM finance_purchase_settlement_order_item "
			+ "WHERE purchase_settlement_order_id=#{purchaseSettlementOrderId}")
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "purchase_settlement_order_id", property = "purchaseSettlementOrderId"),
		@Result(column = "goods_sku_id", property = "goodsSkuId"),
		@Result(column = "purchase_count", property = "purchaseCount"),
		@Result(column = "purchase_price", property = "purchasePrice"),
		@Result(column = "qualified_count", property = "qualifiedCount"),
		@Result(column = "arrival_count", property = "arrivalCount"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	List<PurchaseSettlementOrderItemDO> listByPurchaseSettlementOrderId(
            @Param("purchaseSettlementOrderId") Long purchaseSettlementOrderId);
	
}
