package wep.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import wep.mvc.controller.RestController;

/**
 * 
 * 서버가 start될때 각각의 Controller의 구현체를 미리 생성해서 Map저장 
 */
@WebListener
public class HandlerMappingAjaxListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent e)  { 
        Map<String, RestController> maps = new HashMap<String, RestController>();
        Map<String, Class<?> > clzMap = new HashMap<String, Class<?>>();
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        //~.properties파일 로딩
       ResourceBundle rbs = ResourceBundle.getBundle("ajaxMapping"); //resources/ajaxMapping.properties
       
        try {
	        for(String key : rbs.keySet()) {
	        	String value = rbs.getString(key);
	
	        	Class<?> className = Class.forName(value);
	        	RestController controller = (RestController)className.getDeclaredConstructor().newInstance();
	        	System.out.println(key);
	        	System.out.println(controller);
	        	maps.put(key, controller); 
	        	clzMap.put(key, className);
	        }
        }catch (Exception ex) {
			ex.printStackTrace();
		}
        
        ServletContext application = e.getServletContext();
        application.setAttribute("ajaxMap", maps);
        application.setAttribute("ajaxClzMap", clzMap);
       
    }//메소드끝
	
}//classEnd







