package com.JGG.Section39;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//321
@Configuration // Spring Pure Java configuration
@EnableAspectJAutoProxy // Spring AOP Proxy Support
@ComponentScan("com.JGG.Section39") // Component scan for components and aspects
public class DemoConfig {
}
