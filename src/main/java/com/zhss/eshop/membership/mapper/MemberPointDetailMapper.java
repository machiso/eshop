package com.zhss.eshop.membership.mapper;

import com.zhss.eshop.membership.domain.MemberPointDetailDO;
import com.zhss.eshop.membership.domain.MemberPointDetailQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 会员积分明细管理mapper组件
 * @author zhonghuashishan
 *
 */
@Mapper
public interface MemberPointDetailMapper {

	/**
	 * 分页查询会员积分变更明细 
	 * @param query 查询调价你
	 * @return 会员积分变更明细
	 */
	@Select("SELECT "
				+ "a.id,"
				+ "a.user_account_id,"
				+ "a.old_member_point,"
				+ "a.updated_member_point,"
				+ "a.new_member_point,"
				+ "a.update_reason,"
				+ "a.gmt_create,"
				+ "a.gmt_modified "
			+ "FROM membership_member_point_detail a,"
			+ "("
				+ "SELECT id "
				+ "FROM membership_member_point_detail "
				+ "WHERE user_account_id=#{userAccountId} "
				+ "LIMIT #{offset},#{size} "
			+ ") b "
			+ "WHERE a.id=b.id") 
	@Results({
		@Result(column = "id", property = "id", id = true),
		@Result(column = "user_account_id", property = "userAccountId"),
		@Result(column = "old_member_point", property = "oldMemberPoint"),
		@Result(column = "updated_member_point", property = "updatedMemberPoint"),
		@Result(column = "new_member_point", property = "newMemberPoint"),
		@Result(column = "update_reason", property = "updateReason"),
		@Result(column = "gmt_create", property = "gmtCreate"),
		@Result(column = "gmt_modified", property = "gmtModified")
	})
	List<MemberPointDetailDO> listByPage(MemberPointDetailQuery query);
	
	/**
	 * 新增会员积分明细
	 * @param memberPointDetail 会员积分明细
	 */
	@Insert("INSERT INTO membership_member_point_detail("
				+ "user_account_id,"
				+ "old_member_point,"
				+ "updated_member_point,"
				+ "new_member_point,"
				+ "update_reason,"
				+ "gmt_create,"
				+ "gmt_modified"
			+ ") VALUES("
				+ "#{userAccountId},"
				+ "#{oldMemberPoint},"
				+ "#{updatedMemberPoint},"
				+ "#{newMemberPoint},"
				+ "#{updateReason},"
				+ "#{gmtCreate},"
				+ "#{gmtModified}"
			+ ")") 
	@Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
	void save(MemberPointDetailDO memberPointDetail);
	
}
