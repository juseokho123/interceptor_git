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
    	
    	HttpSession session = request.getSession();
    	String memberId =(String) session.getAttribute("memberId");
    	    	
    	//명확한 String 개체가 앞에 있어야 하고 변수는 뒤쪽으로 와야된다. 앞에는 null이 떨어지지 않는 명확한 객체가 꼭 와야한다.
    	if(memberId != null) {
    		//true 정상적으로 도달하는 페이지로 감
    		return true;
    	}else {
    		try {
    			//실패 했을경우 지정한페이지로 보내준다.
    			response.sendRedirect("/login");
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    		return false;
    	}
        
    }    
   
}