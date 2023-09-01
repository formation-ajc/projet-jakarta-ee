package com.projet.projetjakartaee.servlets.user;

import com.projet.projetjakartaee.database.Database;
import com.projet.projetjakartaee.entity.User;
import com.projet.projetjakartaee.repository.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProfileServlet", value = "/user/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/user/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();

        UserRepository userRepository = new UserRepository(Database.getInstanceEmf());

        if(email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || firstname.isEmpty() || lastname.isEmpty()) {
            request.setAttribute("error", "Fields must not be empty !");
            request.getRequestDispatcher("/WEB-INF/user/profile.jsp").forward(request, response);
        }
        else {
            if(password.equals(confirmPassword)) {
                try {
                    User newUser;
                    newUser = userRepository.update(new User(id, email, password, firstname, lastname));
                    request.getSession().removeAttribute("user");
                    request.getSession().setAttribute("user", newUser);
                } catch (SQLException e) {
                    request.setAttribute("error", "Existing account !");
                    request.getRequestDispatcher("/WEB-INF/user/profile.jsp").forward(request, response);
                }
                response.sendRedirect(request.getContextPath() + "/home");
            }
            else {
                request.setAttribute("error", "Passwords must be identical !");
                request.getRequestDispatcher("/WEB-INF/user/profile.jsp").forward(request, response);
            }
        }
    }
}