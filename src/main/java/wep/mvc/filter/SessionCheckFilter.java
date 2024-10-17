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
import wep.mvc.dto.HostDTO;
import wep.mvc.dto.UsersDTO;

@WebFilter(urlPatterns = "/front")
public class SessionCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		String errorMsg = null;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		UsersDTO user = (UsersDTO) session.getAttribute("loginUser");
		HostDTO host = (HostDTO) session.getAttribute("loginCom");

		// 로그인 안한채로 가려고 하면 login하라고 한다( mypage, fes, messagerAndAlram, reservation )
		if (key == null || key.equals("mypage") || key.equals("fes") || key.equals("messageAndAlram")
				|| key.equals("reservation") || key.equals("board")) {
			req = (HttpServletRequest) request;
			session = req.getSession();

			if (session.getAttribute("loginUser") == null && session.getAttribute("loginCom") == null) {

				if (key.equals("board") && methodName.equals("write") || methodName.equals("delete")
						|| methodName.equals("update") || methodName.equals("moveWritePage")
						|| methodName.equals("moveWritePageFree")) {
					req.getRequestDispatcher("user/login.jsp").forward(request, response);
					return;

				} else if (key.equals("reservation") && methodName.equals("resv") || methodName.equals("cancle")
						|| methodName.equals("insert") || methodName.equals("selectByUserSeq")
						|| methodName.equals("selectByResvSeq") || methodName.equals("selectBySVCID")
						|| methodName.equals("revMove") || methodName.equals("selectFes")
						|| methodName.equals("payment") || methodName.equals("viewDetail")) {
					req.getRequestDispatcher("user/login.jsp").forward(request, response);
					return; // 함수 빠져나가기

				} else if (key.equals("mypage") && methodName.equals("selectUser") || methodName.equals("resSelectAll")
						|| methodName.equals("delete") || methodName.equals("update") || methodName.equals("resSelect")
						|| methodName.equals("resDelete") || methodName.equals("reviewSelectAll")
						|| methodName.equals("reviewSelect") || methodName.equals("likeSelectAll")
						|| methodName.equals("likeSelect") || methodName.equals("likeDelete")
						|| methodName.equals("balancePlus")) {
					req.getRequestDispatcher("user/login.jsp").forward(request, response);
					return; // 함수 빠져나가기
					
				} else if (key.equals("messageAndAlram") && methodName.equals("mMove") || methodName.equals("cancle")) {
					req.getRequestDispatcher("user/login.jsp").forward(request, response);
					return; // 함수 빠져나가기
				}
			}
		}
		chain.doFilter(req, response);
	}
}
