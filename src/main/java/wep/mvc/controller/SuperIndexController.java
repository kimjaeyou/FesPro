package wep.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SuperIndexController implements Controller {

	public ModelAndView openTheDoor(HttpServletRequest request,HttpServletResponse response) {
		
		return new ModelAndView("super/Mypage.jsp");
	}
}
