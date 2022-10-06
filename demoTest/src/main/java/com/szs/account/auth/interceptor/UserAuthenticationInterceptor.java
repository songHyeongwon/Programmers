package com.szs.account.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.szs.account.auth.JwtTokenProvider;

@Component
public class UserAuthenticationInterceptor implements HandlerInterceptor {

	private AuthorizationExtractor authExtractor;
    private JwtTokenProvider jwtTokenProvider;
    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO 인증 토큰 처리 구현
		System.out.println(">>> interceptor.preHandle 호출");
        String token = authExtractor.extract(request, "Bearer");
        if (StringUtils.isEmpty(token)) {
            return true;
        }

        if (!jwtTokenProvider.validateToken(token)) {
            throw new IllegalArgumentException("유효하지 않은 토큰");
        }

        String name = jwtTokenProvider.getSubject(token);
        request.setAttribute("name", name);
        return true;
	}
}
