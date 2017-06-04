package com.revature.ers.servlets;

import com.revature.ers.pojos.User;
import com.revature.ers.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;

    private boolean authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = false;
        HttpSession session = request.getSession(true);

        User user = (User) session.getAttribute("user");
        if (user != null) {
            result = true;
        }

        return result;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (authenticate(request, response)) {
            if ( ((User)request.getSession().getAttribute("user")).isManager()) {
                response.sendRedirect("/ManagerHome");
            } else {
                response.sendRedirect("/EmployeeHome");
            }
        } else {
            response.sendRedirect("/Login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
