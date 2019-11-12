package mk.finki.ukim.wp.lab.web.servlets;

import mk.finki.ukim.wp.lab.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "pizza-order-servlet", urlPatterns = "/pizzaOrder.do")
public class PizzaOrderServlet extends HttpServlet {
    private final SpringTemplateEngine engine;

    public PizzaOrderServlet(SpringTemplateEngine engine){
        this.engine = engine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        String pizzaType = order.getPizzaType();

        String pizzaSize = req.getParameter("pizzaSize");
        order.setPizzaSize(pizzaSize);

        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("pizzaType", pizzaType);
        context.setVariable("pizzaSize", pizzaSize);
        this.engine.process("deliveryInfo.html",context,resp.getWriter());
    }
}
