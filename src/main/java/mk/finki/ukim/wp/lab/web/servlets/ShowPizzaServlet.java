package mk.finki.ukim.wp.lab.web.servlets;

import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "show-pizza-servlet", urlPatterns = "")
public class ShowPizzaServlet extends HttpServlet {
    private final PizzaService service;
    private final SpringTemplateEngine engine;

    public ShowPizzaServlet(PizzaService service, SpringTemplateEngine engine){
        this.service = service;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<Pizza> pizzas = service.listPizzas();
        context.setVariable("pizzas", pizzas);
        resp.setContentType("text/html; charset=UTF-8");
        this.engine.process("listPizzas.html",context,resp.getWriter());
    }
}
