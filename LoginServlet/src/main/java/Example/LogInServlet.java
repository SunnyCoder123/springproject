package Example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class LogInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Abhi".equals(username) && "@123".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            out.println("<h2>Welcome " + username + "!</h2>");
            out.println("<a href='LogOutServlet'>Log out</a>");
        } else {
          	out.println("<h3>Invalid Username or Password</h3>");
        	response.sendRedirect("login.html"); // assuming login.html is your login page
        }
    }
}