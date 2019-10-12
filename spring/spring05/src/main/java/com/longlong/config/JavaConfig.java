package com.longlong.config;

import com.longlong.bean.DataSource;
import com.longlong.bean.RedisConfig;
import com.longlong.cmd.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.longlong.bean",useDefaultFilters = false,includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Service.class)
})
@ImportResource(locations = "classpath:applicationContext.xml")
public class JavaConfig {

    /**
     *  @Profile注解相当于一个标记，标记当前的dataSource是开发环境下，还是生产环境
     * @return
     */
    @Bean("ds")
    @Profile("dev")
    DataSource devDs(){
        return new DataSource("jdbc:mysql://127.0.0.1:3306/dev","dev","dev");
    }

    @Bean("ds")
    @Profile("prod")
    DataSource prodDs(){
        return new DataSource("jdbc:mysql://127.0.0.1:3306/prod","prod","prod");
    }

    @Bean("rc")
    @Profile("dev")
    RedisConfig devRc(){
        return new RedisConfig("127.0.0.1","123");
    }

    @Bean("rc")
    @Profile("prod")
    RedisConfig prodRc(){
        return new RedisConfig("127.0.0.99","123");
    }

    @Bean("cmd")
    @Conditional(WinCondition.class)
    ShowCmd win(){
        return new WinShowCmd();
    }

    @Bean("cmd")
    @Conditional(LinuxCondition.class)
    ShowCmd linux(){
        return new LinuxShowCmd();
    }
}
