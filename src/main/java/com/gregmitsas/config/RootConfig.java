package com.gregmitsas.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.gregmitsas.service" })
public class RootConfig
{
}