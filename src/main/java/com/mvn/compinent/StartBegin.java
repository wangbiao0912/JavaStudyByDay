package com.mvn.compinent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 项目启动开始后执行
 * @author wangbiao
 *
 */
@Component
@Slf4j
public class StartBegin implements CommandLineRunner {

	@Autowired
	private CronComponent jvm;


	@Value("${com.web.action}")
	private String userName;
    @Value("${com.web.name}")
    private  String beginName;
	@Override
	public void run(String... args) throws Exception {
        System.out.println("1111111111111111");
		
	}
	

    //每10分钟执行一次
    @Scheduled(fixedRate = 1000 * 60 * 1)
    private void doSomething() {
	    //log.info("取出来的值："+mo.getName()+"......."+mo.getTitle());
	    //new Thread().sleep(111);
        log.info(userName+"..");
        //jvm内存的使用情况打印
        //jvm.doSomething();;
       
    }

	
}
