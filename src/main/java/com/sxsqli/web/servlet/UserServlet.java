package com.sxsqli.web.servlet;

import com.sxsqli.domain.User;
import com.sxsqli.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if ("check".equals(op)) {
            checkUser(request, response);
        }
    }

    private void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new UserService().checkUser(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/header.jsp").include(request,response);
            response.getWriter().println("<div class=\"content\">\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"row\">" +
                    "<h1>账户或密码错误，<span id='time'>2</span>秒后返回</h1>" +
                    "</div></div></div>");
            response.getWriter().println("<script type='text/javascript' src='js/main.js'></script>");
            response.setHeader("Refresh", "2;login.jsp");
            request.getRequestDispatcher("/footer.jsp").include(request,response);
        }
    }
}
