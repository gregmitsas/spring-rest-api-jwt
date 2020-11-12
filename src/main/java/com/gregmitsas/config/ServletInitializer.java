package com.gregmitsas.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gregmitsas.config.security.SecurityConfig;
import com.gregmitsas.filters.JwtRequestFilter;
import com.gregmitsas.utils.JwtUtil;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[] { RootConfig.class, JwtUtil.class, JwtRequestFilter.class, SecurityConfig.class,
				JpaConfig.class };
	}
}
