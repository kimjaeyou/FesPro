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

//@WebFilter(urlPatterns = "/front")
public class SessionCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		UsersDTO user = (UsersDTO) session.getAttribute("loginUser");
		HostDTO host = (HostDTO) session.getAttribute("loginCom");

		// 로그인 안하고 사용하면 막기
		if (key == null || key.equals("mypage") || key.equals("fes") || key.equals("messagerAndAlram")
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

				} else if (key.equals("messageAndAlram") && methodName.equals("mMove")
						|| methodName.equals("sendAlarm")) {
					req.getRequestDispatcher("user/login.jsp").forward(request, response);
					return; // 함수 빠져나가기
				}
			}

		}

		chain.doFilter(req, response);
	}
}
//		// 로그인 인증하기
//		if (session.getAttribute("loginUser") != null && session.getAttribute("loginCom") == null) {
//			if (user.getUser_ben_check() != 1) {
//				// 정지된 아이디라는 메세지 출력
//				req.getRequestDispatcher("user/login.jsp").forward(request, response);
//				return;
//
//			} else {
//				// 정상적인 로그인 성공
//				req.getRequestDispatcher("user/main.jsp").forward(request, response);
//				request.setAttribute("message", "로그인성공.");
//				return;
//			}
//
//		} else if (session.getAttribute("loginCom") != null && session.getAttribute("loginUser") == null) {
//			if (host.getHost_ben_check() == 1) {
//				// 정상적인 로그인 성공
//				req.getRequestDispatcher("user/main.jsp").forward(request, response);
//				return;
//
//			} else {
//				// 정지된 아이디라는 메세지 출력
//				req.getRequestDispatcher("user/main.jsp").forward(request, response);
//				return;
//
//			}
//		}
