package com.cn.seckill.service;

import java.util.List;

import com.cn.seckill.dto.Exposer;
import com.cn.seckill.dto.SeckillExecution;
import com.cn.seckill.entity.Seckill;
import com.cn.seckill.exception.RepeatKillException;
import com.cn.seckill.exception.SeckillCloseException;
import com.cn.seckill.exception.SeckillException;

/**
 * 业务接口:站在使用者的角度设计接口
 * 三个方面:
 * 1.方法定义粒度,方法定义得要非常清楚
 * 2.参数越简练越好
 * 3.返回类型友好
 * @author hkh
 *
 */
public interface SeckillService {
	/**
	 * 查询秒杀商品列表
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 根据id查询单个秒杀记录
	 * @param SeckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开启时输出秒杀接口地址
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀商品操作
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution excuteSckill(long seckillId,long userPhone,String md5)throws SeckillException,RepeatKillException,SeckillCloseException;
	
	
}
