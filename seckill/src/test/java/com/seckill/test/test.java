package com.seckill.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.seckill.dao.SeckillDao;
import com.cn.seckill.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class test {
	@Resource
	private SeckillDao seckillDao;
	@Test
	public void test1(){
		long seckillId = 1004;
		Seckill seckill = seckillDao.queryById(seckillId);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	
	@Test
	public void test2(){
		List<Seckill> seckills = seckillDao.queryAll(1, 2);
		System.out.println(seckills.get(0).getName());
	}
}
