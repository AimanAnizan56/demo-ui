package demoui.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/RedirectServlet")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String href = (String) request.getParameter("href");
        if (href == null) {
            response.sendRedirect("./");
            return;
        }
        System.out.println("Redirect Link: " + href + ".jsp");
        response.sendRedirect(href + ".jsp");
    }
}
