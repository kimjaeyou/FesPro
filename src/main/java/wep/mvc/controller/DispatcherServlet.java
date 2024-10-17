package wep.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = "/front")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, // 5M - 한 번에 업로드 할 수 있는 파일 크기 제한
      maxRequestSize = 1024 * 1024 * 50 // 50M -전체 요청의 크기 제한. 기본값은 무제한
)
public class DispatcherServlet extends HttpServlet {

   private Map<String, Controller> map = null;
   private Map<String, Class<?>> classMap = null;

   @Override
   public void init(ServletConfig config) throws ServletException {
      ServletContext app = config.getServletContext();
      map = (Map<String, Controller>) app.getAttribute("map");
      classMap = (Map<String, Class<?>>) app.getAttribute("classMap");
   }

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String key = req.getParameter("key");
      String methodName = req.getParameter("methodName");
      System.out.println(key+" = " + methodName);
      try {
         Controller con = map.get(key);

         Class<?> className = classMap.get(key);

         Method method = className.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

         ModelAndView mv = (ModelAndView) method.invoke(con, req, resp);

         if (mv != null) {
            if (mv.isRedirect()) {
               resp.sendRedirect(mv.getViewName());
            } else {
               req.getRequestDispatcher(mv.getViewName()).forward(req, resp);
            }
         } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "ModelAndView is null");
         }
      } catch (Exception ex) {
         ex.printStackTrace();
         resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
      }
   }
}
