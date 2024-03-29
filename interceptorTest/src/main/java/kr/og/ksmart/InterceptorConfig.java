package kr.og.ksmart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier(value = "loginInterceptor")
	private HandlerInterceptor loginInterceptor;
			
	
	// application.properties에 설정된 값을 가지고 오기

	@Value("${resources.notload.list}") 
	private List<String> notLoadList;

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//제외 처리		
		notLoadList.add("/login");
		notLoadList.add("/loginProcess");
		notLoadList.add("/logoutProcess");
		notLoadList.add("/");
		notLoadList.add("/notPermission");
		
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(notLoadList);
			
		
		/*
		 * registry.addInterceptor(commonInterceptor) .addPathPatterns("/**") // 추가할 url
		 * 패턴 .excludePathPatterns("/user/**"); // 제외할 url 패턴
		 */
	}
}
