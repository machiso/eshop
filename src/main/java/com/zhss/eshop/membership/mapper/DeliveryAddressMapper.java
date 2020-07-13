package com.zhss.eshop.membership.mapper;

import com.zhss.eshop.membership.domain.DeliveryAddressDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 收货地址管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface DeliveryAddressMapper {

	/**
	 * 查询用户账号的所有收货地址
	 * @param userAccountId 用户账号id
	 * @return 所有收货地址
	 */
	@Select("SELECT "
				+ "id,"
				+ "user_account_id,"
				+ "province,"
				+ "city,"
				+ "district,"
				+ "consignee,"
				+ "address,"
				+ "phone_number,"
				+ "gmt_create,"
				+ "gmt_modified "
			+ "FROM membership_delivery_address "
			+ "WHERE user_account_id=#{userAccountId}") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "province", property = "province"),
		@Result(column = "city", property = "city"),
		@Result(column = "district", property = "district"),
		@Result(column = "consignee", property = "consignee"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone_number", property = "phoneNumber"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<DeliveryAddressDO> listAllByUserAccountId(
            @Param("userAccountId") Long userAccountId);
	
	/**
	 * 新增收货地址
	 * @param deliveryAddress 收货地址
	 */
	@Insert("INSERT INTO membership_delivery_address("
				+ "user_account_id,"
				+ "province,"
				+ "city,"
				+ "district,"
				+ "consignee,"
				+ "address,"
				+ "phone_number,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{province},"
				+ "#{city},"
				+ "#{district},"
				+ "#{consignee},"
				+ "#{address},"
				+ "#{phoneNumber},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")")  
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true) 
	void save(DeliveryAddressDO deliveryAddress);
	
	/**
	 * 更新收货地址
	 * @param deliveryAddress 收货地址
	 */
	@Update("UPDATE membership_delivery_address SET "
				+ "province=#{province},"
				+ "city=#{city},"
				+ "district=#{district},"
				+ "consignee=#{consignee},"
				+ "address=#{address},"
				+ "phone_number=#{phoneNumber},"
				+ "gmt_modified=#{gmtModified} "
			+ "WHERE id=#{id}") 
	void update(DeliveryAddressDO deliveryAddress); 
	
	/**
	 * 删除收货地址
	 * @param id 收货地址id
	 */
	@Delete("DELETE FROM membership_delivery_address WHERE id=#{id}")  
	void remove(@Param("id") Long id);
	
}
