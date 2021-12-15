package com.VEA.TestWeb;

import com.VEA.TestWeb.Converters.ContainerToDetailViewModelConverter;
import com.VEA.TestWeb.Converters.TransportMeanToDetailViewModelConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestWebApplication.class, args);
	}

	@Configuration
	static class MyConfig implements WebMvcConfigurer {
		@Override
		public void addFormatters(FormatterRegistry registry) {
			registry.addConverter(new TransportMeanToDetailViewModelConverter());
			registry.addConverter(new ContainerToDetailViewModelConverter());
		}
	}

}
