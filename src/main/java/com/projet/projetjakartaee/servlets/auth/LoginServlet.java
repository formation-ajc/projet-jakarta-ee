package com.projet.projetjakartaee.servlets.auth;

import com.projet.projetjakartaee.database.Database;
import com.projet.projetjakartaee.entity.User;
import com.projet.projetjakartaee.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserRepository userRepository = new UserRepository(Database.getInstanceEmf());

        try {
            User user = userRepository.getByEmailAndPassword(email, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home");
            }
            else {
                request.setAttribute("error", "Wrong login or password !");
                request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("error");
            request.setAttribute("error", "Wrong login or password !");
            request.getRequestDispatcher("/WEB-INF/auth/login.jsp").forward(request, response);
        }

    }
}