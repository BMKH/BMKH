package com.seckill.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.seckill.dao.SuccessKilledDao;
import com.cn.seckill.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class test2 {
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void test3(){
		successKilledDao.insertSuccessKilled(1008, 123);
	}
	@Test
	public void test4(){
		SuccessKilled success = successKilledDao.queryByIdWithSeckill(1007, 123);
		System.out.println(success.getState());
	}
}
