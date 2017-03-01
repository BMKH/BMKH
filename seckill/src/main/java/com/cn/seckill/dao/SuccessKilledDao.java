package com.cn.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.cn.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
	/**
	 * 插入购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * 根据组合id查询购买明细
	 * @param seckillId
	 * @param userPhone
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
