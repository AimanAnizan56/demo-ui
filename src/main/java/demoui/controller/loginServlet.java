package demoui.controller;

import demoui.connection.postgresql;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");


        try {
            Connection conn = postgresql.getConnection();

            PreparedStatement prepStmt = conn.prepareStatement("SELECT username FROM account WHERE username=? AND password=?");
            prepStmt.setString(1,username);
            prepStmt.setString(2,password);

            ResultSet result = prepStmt.executeQuery();

            if (result.getRow() == 1) {
                String currentUsername = result.getString(1);

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();

                out.println("<html><body>");
                out.println("<h1>Hello " + currentUsername + " </h1>");
                out.println("</body></html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
