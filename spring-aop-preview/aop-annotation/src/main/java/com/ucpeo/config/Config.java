package com.ucpeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.ucpeo")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {
}
