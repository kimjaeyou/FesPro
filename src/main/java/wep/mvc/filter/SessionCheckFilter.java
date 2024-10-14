/*
package wep.mvc.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/front")
public class SessionCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException { // 이거 이런식으로 코드 짜면 안됨 그럼 둘다 적용됨, 저녁에 다시 수정하자. 일단 이런 구조는 맞음

		String key = request.getParameter("key");
		if (key == null || key.equals("user")) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			if (session.getAttribute("loginUser") == null) {
				req.setAttribute("errorMsg", "로그인하고 이용해주세요.^^");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return;
			}
		} 
		if (key == null || key.equals("host")) {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			if (session.getAttribute("loginCom") == null) {
				req.setAttribute("errorMsg", "로그인하고 이용해주세요.^^");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return;
			}
		}
		chain.doFilter(request, response);
	}
}
*/