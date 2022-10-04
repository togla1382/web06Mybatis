package myConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ContextPathConfigListener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	
    }
	
}
