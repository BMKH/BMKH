package com.cn.seckill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.seckill.entity.Seckill;

public interface SeckillDao {
	/**
	 * 减少库存
	 * @param seckillId
	 * @param killTime
	 * @return
	 */
	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
	/**
	 * 根据id查询商品
	 * @param seckillId
	 * @return
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 商品列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
