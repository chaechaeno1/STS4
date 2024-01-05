package com.e7e.merong.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //얘만 설정해주면 설정파일로 인식함
//@EnableWebMvc //그냥 스프링에서 필요
public class MyConfig  implements WebMvcConfigurer{

	// 브라우저 주소줄에 /mcimg/aaa.jpg 검색 →  웹경로인 c:/myUpload/aaa.jpg 을 찾음
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("요기가 실행되었는지 check?");
		registry.addResourceHandler("/mcimg/**")             // 웹 접근 경로 
		        .addResourceLocations("file:///c:/myUpload/");  // 서버내 실제 경로
				// 'file://' 프로토콜
				// '/c:/myUpload/' 실제경로
	}

}


