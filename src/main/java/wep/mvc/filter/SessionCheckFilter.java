/*package wep.mvc.filter;

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
		String errorMsg = null;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		UsersDTO user = (UsersDTO) session.getAttribute("loginUser");
		HostDTO host = (HostDTO) session.getAttribute("loginCom");

		
		// 처음에 로그인 체크, 그냥 바로 들어갔는지 확인하는거 같은데...
		if (key == null || key.equals("mypage") || key.equals("fes") || key.equals("messageAndAlram")
				|| key.equals("reservation")) {
			req = (HttpServletRequest) request;
			session = req.getSession();
			
			if (session.getAttribute("loginUser") == null
				&& session.getAttribute("loginCom") == null ) {
				req.getRequestDispatcher("user/login.jsp").forward(request, response);
				
				return;// 함수를 빠져나가라
			}
				
		} else if (session.getAttribute("loginCom") == null && session.getAttribute("loginUser") != null
					&& user.getUser_ben_check() == 1) { // 여기는 전부다 유저기능 , 유저회원 로그인 성공 했다면? 밑에 접속 가능

				if (key.equals("board") && methodName.equals("write") || methodName.equals("delete")
						|| methodName.equals("update")) {
					req.getRequestDispatcher("board/boardMain.jsp").forward(request, response);
					return; //함수 빠져나가기

					// reservation 이것도?
				} else if (key.equals("reservation") && methodName.equals("resv") || methodName.equals("cancle")
						|| methodName.equals("insert") || methodName.equals("selectByUserSeq")
						|| methodName.equals("selectByResvSeq") || methodName.equals("selectBySVCID")
						|| methodName.equals("revMove") || methodName.equals("selectFes")
						|| methodName.equals("payment") || methodName.equals("viewDetail")) {
				
					return; //함수 빠져나가기
					// mypage 그럼 이것도?
				} else if (key.equals("mypage") && methodName.equals("selectUser") || methodName.equals("resSelectAll")
						|| methodName.equals("delete") || methodName.equals("update") || methodName.equals("resSelect")
						|| methodName.equals("resDelete") || methodName.equals("reviewSelectAll")
						|| methodName.equals("reviewSelect") || methodName.equals("likeSelectAll")
						|| methodName.equals("likeSelect") || methodName.equals("likeDelete")
						|| methodName.equals("balancePlus")) {

					return; //함수 빠져나가기
				}
				
				// 기업회원 로그인 확인
		} else if (session.getAttribute("loginUser") == null && session.getAttribute("loginCom") != null
					&& host.getHost_ben_check() == 1) { // 여기는 전부다 기업기능

				if (key.equals("path")) {
					errorMsg = "로그인하고 이용해주세요.^^";
					req.setAttribute("errorMsg", errorMsg);
					req.getRequestDispatcher("error/error.jsp").forward(request, response);

					return; //함수 빠져나가기
				}

				return; //함수 빠져나가기
				
		}
		
		 else { // 로그인 실패했을때 errorMsg = "로그인하고 이용해주세요.^^";
		  req.setAttribute("errorMsg", errorMsg);
		  req.getRequestDispatcher("error/error.jsp").forward(request, response);
		  return; //함수 빠져나가기
		  
		  }
		 
		chain.doFilter(request, response);
	}

}
*/
