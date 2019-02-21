package controller;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import dao.Users_crud;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class Servlet WebServlet => It is necessary
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    // Define my two objects
    public Users users;
    public Users_crud users_crud;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // Assigned my two classes in the objects
        try {
            this.users = new Users();
            this.users_crud = new Users_crud();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ----------------------------------------------------------------------------------------------------------------
        // If user has click on the button on form "add" => redirection to the login page
        if (request.getParameter("add") != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

        // If the url countains the user id => data recovery + redirection to the modification form
        if (request.getParameter("get_id") != null) {
            users.setId(Integer.parseInt(request.getParameter("get_id")));
            users = users_crud.readById(users);

            request.setAttribute("users", users);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/editform.jsp");
            dispatcher.forward(request, response);
        }

        // If he just clicked on the link to see the list => loading the list
        if (request.getParameter("add") == null && request.getParameter("edit") == null && request.getParameter("sign_in") == null && request.getParameter("delete") == null) {
            try {
                List<Users> list = users_crud.read();
                request.setAttribute("list", list);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/viewusers.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        // ----------------------------------------------------------------------------------------------------------------
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ----------------------------------------------------------------------------------------------------------------
        String form_submit = "";
        if (request.getParameter("add") != null) {
            form_submit = "add";
        } else if (request.getParameter("delete") != null) {
            form_submit = "delete";
        } else if (request.getParameter("edit") != null) {
            form_submit = "edit";
        } else if (request.getParameter("sign_in") != null) {
            form_submit = "sign_in";
        }

        switch (form_submit) {
            case "add":
                // Retrieves data from fields
                users.setName(request.getParameter("name"));
                users.setPassword(request.getParameter("password"));
                users.setEmail(request.getParameter("email"));
                users.setSex(request.getParameter("sex"));
                users.setCountry(request.getParameter("country"));
                // Insert into database
                users_crud.create(users);
                // Redirect to the login page
                response.sendRedirect("login.jsp");
                break;
            case "delete":
                String id = request.getParameter("id");
                users.setId(Integer.parseInt(id));
                users_crud.delete(users);
                try {
                    users_crud.update(users);
                    List<Users> list = users_crud.read();
                    request.setAttribute("list", list);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/viewusers.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "edit":
                users.setId(Integer.parseInt(request.getParameter("id")));
                users.setName(request.getParameter("name"));
                users.setPassword(request.getParameter("password"));
                users.setEmail(request.getParameter("email"));
                users.setSex(request.getParameter("sex"));
                users.setCountry(request.getParameter("country"));
                try {
                    users_crud.update(users);
                    List<Users> list = users_crud.read();
                    request.setAttribute("list", list);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/viewusers.jsp");
                    dispatcher.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case "sign_in":
                /*  String email = request.getParameter("email");
                int connection = 0;
                String password = request.getParameter("password");

                try {
                    connection = users_crud.login(email, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (connection > 0) {
                    HttpSession session_username = request.getSession();
                    String username = email;
                    session_username.setAttribute("session_username", username);
                    // Reloading to the user list
                    List<Users> list = null;
                    try {
                        list = users_crud.read();
                    } catch (SQLException ex) {
                        Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("list", list);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/viewusers.jsp");
                    dispatcher.forward(request, response);
                } else {
                    HttpServletResponse httpResponse = (HttpServletResponse) response;
                    httpResponse.sendRedirect("login.jsp");
                }*/
                try {
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    // Retrieves data user's via email
                    users = users_crud.getLogin(email);
                    // If the email exist and the password matches => session + redirection with list
                    if (users.getEmail() != null && users.getEmail().equals(email) && users.getPassword() != null && users.getPassword().equals(password)) {
                        // Session
                        HttpSession session_username = request.getSession();
                        String username = users.getName();
                        session_username.setAttribute("session_username", username);
                        // Reloading to the user list
                        List<Users> list = users_crud.read();
                        request.setAttribute("list", list);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewusers.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        HttpServletResponse httpResponse = (HttpServletResponse) response;
                        httpResponse.sendRedirect("login.jsp");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            default:
                System.out.println("Error in Servlet => doPost() => switch");
                break;
        }
        // ----------------------------------------------------------------------------------------------------------------
    }

}
