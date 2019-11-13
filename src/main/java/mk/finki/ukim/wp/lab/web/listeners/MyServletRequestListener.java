package mk.finki.ukim.wp.lab.web.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent event){
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        String method = request.getMethod();
        String servlet = request.getServletPath();
        System.out.println("[WP-Log] {requestDestroyed} - " + "method: " + method + "; servlet path: " + servlet);
    }

    public void requestInitialized(ServletRequestEvent event){
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        String method = request.getMethod();
        String servlet = request.getServletPath();
        System.out.println("[WP-Log] {requestInitialized} - " + "method: " + method + "; servlet path: " + servlet);
    }
}
