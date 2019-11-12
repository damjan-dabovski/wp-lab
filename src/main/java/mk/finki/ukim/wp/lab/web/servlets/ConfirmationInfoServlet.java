package mk.finki.ukim.wp.lab.web.servlets;

import mk.finki.ukim.wp.lab.model.Order;
import mk.finki.ukim.wp.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "confirmation-info-servlet", urlPatterns = "/confirmationInfo.do")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine engine;
    private final OrderService service;

    public ConfirmationInfoServlet(SpringTemplateEngine engine, OrderService service){
        this.engine = engine;
        this.service = service;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());

        HttpSession session = req.getSession();
        String pizzaType = (String) session.getAttribute("pizzaType");
        String pizzaSize = (String) session.getAttribute("pizzaSize");
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        Order order = service.placeOrder(pizzaType, pizzaSize, clientName, clientAddress);

        context.setVariable("ipAddress", req.getRemoteHost());
        context.setVariable("browser", req.getHeader("User-Agent"));
        context.setVariable("order", order);

        engine.process("confirmationInfo.html",context, resp.getWriter());
    }
}
