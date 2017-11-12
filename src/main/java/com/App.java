package com;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@MapperScan("com.zh.gytlv.mapper")
public class App extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		/**
		 * 在main方法中启动我们的应用程序
		 */
		SpringApplication.run(App.class, args);
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		
		// 1.需要定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
		// 2.添加fastJson的配置信息，比如：是否格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 3.在convert中添加配置信息
		fastConvert.setFastJsonConfig(fastJsonConfig);
		// 4.将convert添加到converters当中
		converters.add(fastConvert);
	}
}
