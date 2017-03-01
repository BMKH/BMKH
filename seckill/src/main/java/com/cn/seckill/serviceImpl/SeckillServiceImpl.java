package com.cn.seckill.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.cn.seckill.dao.SeckillDao;
import com.cn.seckill.dao.SuccessKilledDao;
import com.cn.seckill.dto.Exposer;
import com.cn.seckill.dto.SeckillExecution;
import com.cn.seckill.entity.Seckill;
import com.cn.seckill.entity.SuccessKilled;
import com.cn.seckill.enums.SeckillStatEnum;
import com.cn.seckill.exception.RepeatKillException;
import com.cn.seckill.exception.SeckillCloseException;
import com.cn.seckill.exception.SeckillException;
import com.cn.seckill.service.SeckillService;

@Service
public class SeckillServiceImpl implements SeckillService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//注入service依赖
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	//md5盐值字符串,用于混淆md5
	private final String slat="ajgl3080)**()(&2&^*^jflaj#$%^*^(!~~~^&*JFL";
	
	
	@Override
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	@Override
	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	@Override
	public Exposer exportSeckillUrl(long seckillId) {
		Seckill seckill = seckillDao.queryById(seckillId);
		if(seckill==null){
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		//系统当前时间
		Date nowTime = new Date();
		if(nowTime.getTime() < startTime.getTime()||nowTime.getTime()>endTime.getTime()){
			return new Exposer(false, seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		//转化特定字符串
		String md5 = getMD5(seckillId);
		return new Exposer(true,md5,seckillId);
	}

	@Override
	@Transactional
	/**
	 * 使用注解控制事务方法的优点
	 * 1:开发团队达成一致的约定,明确标注事务方法的编程风格
	 * 2:保证事务方法的执行时间尽可能短,不要穿插其他网络操作,RPC/HTTP请求
	 * 3:不是所有的方法都需要事务
	 */
	public SeckillExecution excuteSckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		if(md5==null||!md5.equals(getMD5(seckillId))){
			throw new SeckillException("seckill data rewrite");
		}
		Date nowTime = new Date();
		//执行秒杀逻辑:减库存,记录购买行为
		int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
		//没有更新记录,秒杀结束
		try{
			if(updateCount<=0){
				throw new SeckillCloseException("seckill is close");
			}else{
				//减少库存成功，记录购买行为
				int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
				//唯一验证:seckillId,userPhone
				if(insertCount==0){
					throw new RepeatKillException("seckill repeated"); 
				}else{
					//秒杀成功
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
				}
			}
		}catch(SeckillCloseException e1){
			throw e1;
		}catch(RepeatKillException e2){
			throw e2;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			//所有编译器异常转化为运行期异常
			throw new SeckillException("seckill inner error:"+e.getMessage());
		}
	}
	
	/**
	 * 生成md5
	 * @param seckillId
	 * @return
	 */
	private String getMD5(long seckillId){
		String base = seckillId+"/"+slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}

}
