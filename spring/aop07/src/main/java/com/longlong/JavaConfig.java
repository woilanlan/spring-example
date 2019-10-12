package com.longlong;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @EnableAspectJAutoProxy注解表示开启Java自动代理
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.longlong")
public class JavaConfig {
}
