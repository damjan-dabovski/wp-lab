package mk.finki.ukim.wp.lab.web.servlets;

import mk.finki.ukim.wp.lab.model.Pizza;
import mk.finki.ukim.wp.lab.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "show-pizza-servlet", urlPatterns = "")
public class ShowPizzaServlet extends HttpServlet {
    private final PizzaService service;

    public ShowPizzaServlet(PizzaService service){
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pizza> pizzas = service.listPizzas();
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<ul>");
        pizzas.forEach(p -> writer.write("<li>"+p.getName()+" - " +p.getDescription() + "</li>"));
        writer.write("</ul>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
