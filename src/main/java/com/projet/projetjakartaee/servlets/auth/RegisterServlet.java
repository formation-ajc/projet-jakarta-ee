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

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        UserRepository userRepository = new UserRepository(Database.getInstanceEmf());

        if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || firstname.isEmpty() || lastname.isEmpty()) {
            request.setAttribute("error", "Fields must not be empty !");
            request.getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
        }
        else {
            if(password.equals(confirmPassword)) {
                try {
                    userRepository.create(new User(email, password, firstname, lastname));
                } catch (SQLException e) {
                    request.setAttribute("error", "Existing account !");
                    request.getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
                }
                response.sendRedirect(request.getContextPath() + "/login");
            }
            else {
                request.setAttribute("error", "Passwords must be identical !");
                request.getRequestDispatcher("/WEB-INF/auth/register.jsp").forward(request, response);
            }
        }
    }
}