package com.icss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter("/user/*")
public class UserFilter implements Filter {

    public UserFilter() {
    }

	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		Object object = request.getSession().getAttribute("user");
		if(object != null) {
			//�ѵ�¼
			chain.doFilter(req, res);
		}else {
			//δ��¼��ת���¼ҳ
			request.setAttribute("msg", "��������ҳ�棬���ȵ�¼...");
			request.getRequestDispatcher("/WEB-INF/main/login.jsp").forward(request, res);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
