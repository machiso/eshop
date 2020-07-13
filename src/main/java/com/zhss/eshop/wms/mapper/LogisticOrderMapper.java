package com.zhss.eshop.wms.mapper;

import com.zhss.eshop.wms.domain.LogisticOrderDO;
import org.apache.ibatis.annotations.*;

/**
 * 物流单管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface LogisticOrderMapper {

	/**
	 * 新增物流单
	 * @param logisticOrder 物流单
	 */
	@Insert("INSERT INTO wms_logistic_order("
				+ "sale_delivery_order_id,"
				+ "logistic_code,"
				+ "content,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{saleDeliveryOrderId},"
				+ "#{logisticCode},"
				+ "#{content},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(LogisticOrderDO logisticOrder);
	
	/**
	 * 根据销售出库单id查询物流单
	 * @param saleDeliveryOrderId 销售出库单id
	 * @return 物流单
	 */
	@Select("SELECT "
				+ "id,"
				+ "sale_delivery_order_id,"
				+ "logistic_code,"
				+ "content,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM wms_logistic_order "
			+ "WHERE sale_delivery_order_id=#{saleDeliveryOrderId}")    
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "sale_delivery_order_id", property = "saleDeliveryOrderId"),
		@Result(column = "logistic_code", property = "logisticCode"),
		@Result(column = "content", property = "content"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified") 
	})
	LogisticOrderDO getBySaleDeliveryOrderId(
            @Param("saleDeliveryOrderId") Long saleDeliveryOrderId);
	
}
