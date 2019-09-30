package com.slk.web.framework.Tsak;

import com.slk.web.framework.Exception.CustimExceptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * Create by 杨明 2019/6/20 0020 下午 16:40
 */
//@Configuration
@Component //(把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>)
@Lazy(false) //用于标识bean是否需要延迟加载
@EnableScheduling //启用定时任务
public class Test {

    public static int randoms=0;

    private static Logger logger = LoggerFactory.getLogger(CustimExceptionResolver.class);

    @Scheduled(cron = "0 * * * * ?") //每一分钟执行一次该方法
    public void TaskEnd(){
        randoms=(int)((Math.random()*9+1)*10000);
        System.out.println("------------------定时任务："+randoms+"------------------");
    }

    public static int getRandoms() {
        return randoms;
    }

    public static void setRandoms(int randoms) {
        Test.randoms = randoms;
    }

}
