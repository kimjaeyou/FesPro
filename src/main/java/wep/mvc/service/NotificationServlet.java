package wep.mvc.service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sendNotification")
public class NotificationServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("여기");
        String message = request.getParameter("message");
        
        // 서버측에서 응답을 작성합니다.
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Notification</title></head>");
        out.println("<body>");
        out.println("<h1>Notification: " + message + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
