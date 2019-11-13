package mk.finki.ukim.wp.lab.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event){
        System.out.println("[WP-Log] {contextInitialized}");
    }

    public void contextDestroyed(ServletContextEvent event){
        System.out.println("[WP-Log] {contextDestroyed}");
    }

}
