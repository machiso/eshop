package com.zhss.eshop.order.mapper;

import com.zhss.eshop.order.domain.OrderOperateLogDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 订单操作日志管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface OrderOperateLogMapper {

	/**
	 * 新增订单操作日志
	 * @param log 订单操作日志
	 */
	@Insert("INSERT INTO order_operate_log("
				+ "order_info_id,"
				+ "operate_type,"
				+ "operate_content,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
			 	+ "#{orderInfoId},"
			 	+ "#{operateType},"
			 	+ "#{operateContent},"
			 	+ "#{gmtCreate},"
			 	+ "#{gmtModified}"
			 + ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(OrderOperateLogDO log);
	
	/**
	 * 查询订单操作日志
	 * @param orderInfoId 订单id
	 * @return 订单操作日志
	 */
	@Select("SELECT "
				+ "id,"
				+ "order_info_id,"
				+ "operate_type,"
				+ "operate_content,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM order_operate_log "
			+ "WHERE order_info_id=#{orderInfoId}")  
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "order_info_id", property = "orderInfoId"),
		@Result(column = "operate_type", property = "operateType"),
		@Result(column = "operate_content", property = "operateContent"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<OrderOperateLogDO> listByOrderInfoId(
            @Param("orderInfoId") Long orderInfoId);
	
}
