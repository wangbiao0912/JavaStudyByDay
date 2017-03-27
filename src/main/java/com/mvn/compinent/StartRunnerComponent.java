package com.mvn.compinent;

import com.mvn.repository.MyTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhaogj on 17/11/2016.
 * 工程启动时需要加载的动作写在这里
 */
@Component
@Slf4j
@Order(value = 1)
public class StartRunnerComponent  implements CommandLineRunner   {

    @Autowired
    private MyTestRepository myTestR;
    @Override
    public void run(String... args) throws Exception {
        log.info("start init");
          myTestR.doSomething();
        log.info("end init");
    }

    @Autowired
    private CronComponent jvm;
    @Value("${com.web.action}")
    private String userName;
    @Value("${com.web.name}")
    private  String beginName;

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
