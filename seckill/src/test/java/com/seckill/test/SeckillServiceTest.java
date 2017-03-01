package com.seckill.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.seckill.dto.Exposer;
import com.cn.seckill.entity.Seckill;
import com.cn.seckill.service.SeckillService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void list() throws Exception{
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}",list);
	}
	@Test
	public void getByid(){
		Seckill seckill = seckillService.getById(1004);
		logger.info("seckill={}",seckill);
	}
	
	@Test
	public void exportSeckillUrl(){
		long id = 1004;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		logger.info("exposer={}",exposer);
	}
	
}
