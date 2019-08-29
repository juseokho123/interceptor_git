package kr.og.ksmart;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
      
    // 요청을 컨트롤러에 보내기 전 작업
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
// 		/logger.info("LoginInterceptor - {}", "호출완료");
    	logger.info("info - {}", "호출완료");
    	logger.debug("debug - {}", "호출완료");
    	logger.error("error - {}", "호출완료");
    	logger.warn("warn - {}", "호출완료");
    	logger.trace("trace - {}", "호출완료");
    	
    	String sessionCheck = request.getParameter("sessionCheck");
    	if("Y".equals(sessionCheck)) {
    		return true;
    	}else {
    		try {
    			response.sendRedirect("/notPermission");
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    		return false;
    	}
        
    }    
   
}