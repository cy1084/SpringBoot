package com.min.edu.filter;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

//view의 요청 정보를 필터를 통해 로그 생성
//필터는 스프링꺼 아님
//webfilter 방식은 세밀하게 요청되는 주소 설정 가능
//@WebFilter(urlPatterns = "/*",filterName="TestFilter")

@Slf4j
@Component
//Component 방식은 urlPatterns 지정 불가 -> 모든 이동을 가로채기 할 수 있음
//Order를 통해 순서를 지정할 수는 있음
public class TestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		String url = StringUtils.defaultIfEmpty(req.getRequestURL().toString(), "");
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");

		log.info("요청된 클라이언트 정보 {} / {}", url, queryString);
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("😘🥰🤗 필터 들어왔당");
	}

	@Override
	public void destroy() {
		log.info("😘🥰🤗 필터 나갔당");
	}
}
