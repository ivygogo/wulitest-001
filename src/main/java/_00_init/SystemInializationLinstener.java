package _00_init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import _00_init.util.GlobalService;

/**
 * Application Lifecycle Listener implementation class SystemInializationLinstener
 *
 */
@WebListener
public class SystemInializationLinstener implements ServletContextListener {

    public SystemInializationLinstener() {
       
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	GlobalService gs = new GlobalService();
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("SYSTEM", gs);
    }
	
}
