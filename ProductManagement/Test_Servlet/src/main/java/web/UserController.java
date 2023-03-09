package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/register")
public class UserController extends HttpServlet{

	 private static final long serialVersionUID = 1L;
	 
	    private UserDAO userDao;
	    
	    public void init() {
	        userDao = new UserDAO();
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        register(request, response);
	    	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        response.sendRedirect("webapp/register.jsp");
	    	    }
	    
	    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        User employee = new User();
	        employee.setFirstName(firstName);
	        employee.setLastName(lastName);
	        employee.setUserName(username);
	        employee.setPassword(password);
	       


	        try {
	            int result = userDao.registerEmployee(employee);
	            if (result == 1) {
	                request.setAttribute("NOTIFICATION", "User Registered Successfully!");
	            }

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
	        if(dispatcher!=null) {
	        	dispatcher.forward(request, response);
	        }
	        else {
	            throw new ServletException("RequestDispatcher for resource.jsp not found.");
	        }
	    }
}
