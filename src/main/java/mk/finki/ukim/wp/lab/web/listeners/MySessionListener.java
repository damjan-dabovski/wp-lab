package mk.finki.ukim.wp.lab.web.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent event){
        System.out.println("[WP-Log] {sessionCreated}");
    }

    public void sessionDestroyed(HttpSessionEvent event){
        System.out.println("[WP-Log] {sessionDestroyed}");
    }
}
