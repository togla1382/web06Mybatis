package config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.dto.member.LogInfo;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter(urlPatterns = {"/member/detail","/member/update","/member/delete"})
public class LoginCheckFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter:로그인한 회원에대한 기능 사용시 현재도 권한이 있는지 체크");
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session=req.getSession();
		LogInfo logData= (LogInfo) session.getAttribute("logData");
		
		if(logData==null) {
			HttpServletResponse resp= (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath()+"/signin?logout");
			System.out.println("세션이 유지되지 않았어요. 인증하여야합니다.");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
