package demoui.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FormServlet", value = "/FormServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = (String) session.getAttribute("action");
        if(action.equals("login")) {
            // redirect page login
            System.out.println("page login");
        } else if (action.equals("signup")) {
            // redirect page signup
            System.out.println("page signup");
        }
    }
}
