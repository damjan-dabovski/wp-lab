package mk.finki.ukim.wp.lab.web.servlets;
import mk.finki.ukim.wp.lab.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "select-pizza-servlet", urlPatterns = "/selectPizza.do")
public class SelectPizzaServlet extends HttpServlet {
    private final SpringTemplateEngine engine;

    public SelectPizzaServlet(SpringTemplateEngine engine){
        this.engine = engine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext context = new WebContext(req, resp, req.getServletContext());
        String pizzaType = req.getParameter("pizzaType");
        if(pizzaType == null){
            resp.sendRedirect("");
            return;
        }

        Order order = new Order();
        order.setPizzaType(pizzaType);
        HttpSession session = req.getSession(true);
        session.setAttribute("order", order);

        context.setVariable("pizzaType", pizzaType);
        resp.setContentType("text/html; charset=UTF-8");
        this.engine.process("selectPizzaSize.html",context,resp.getWriter());
    }
}
