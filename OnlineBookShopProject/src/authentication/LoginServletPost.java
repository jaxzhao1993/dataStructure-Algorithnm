package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Authenticator.Success;

/**
 * Servlet implementation class SimpleServlet
 */
public class LoginServletPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		String username =  request.getParameter("userName");
		String passWord =  request.getParameter("passWord");
		System.out.println("This is doPost()");
			if (username.equals(getServletConfig().getInitParameter("userNameDefault"))
				&& passWord.equals(getServletConfig().getInitParameter("passWordDefault"))	) {
				response.sendRedirect("Success.jsp");
			}
		else {
			writer.println("username:  "+username);
			writer.println("password:  "+passWord);
		}
		
	}

}
