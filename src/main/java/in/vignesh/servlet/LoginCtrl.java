package in.vignesh.servlet;

import java.io.IOException;


import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vignesh.dao.LoginDAO1;
import in.vignesh.model.UserBean;


/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtrl() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);
		request.getRequestDispatcher("userhome.jsp").forward(request, response);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside post");
		String cusId = request.getParameter("customerid");
		String pass = request.getParameter("password");
		UserBean bean = new UserBean();
		bean.setCustomerId(cusId);
		bean.setPassword(pass);
		LoginDAO1 dao = new LoginDAO1();
		try {
			String result = dao.authenticateUser(bean);
			System.out.println("result " + result);
			if (result.equals("ADMIN_ROLE")) {
				System.out.println("inside admin");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("admin", cusId);
				request.setAttribute("customerid", cusId);
				System.out.println(cusId);
				response.sendRedirect("adminhome.jsp");
			}
			if (result.equals("USER_ROLE")) {
				System.out.println("inside auser");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", cusId);
				request.setAttribute("customerid", cusId);
				System.out.println(cusId);
				response.sendRedirect("userhome.jsp");
			}
			if (result.equals("INVALID")) {
				System.out.println("invalid");
				String msg = "Please enter valid Username or password";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
