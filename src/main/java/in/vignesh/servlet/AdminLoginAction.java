package in.vignesh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vignesh.service.AdminLogin;

/**
 * Servlet implementation class AdminLoginAction
 */
@WebServlet("/AdminLoginAction")
public class AdminLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerId = request.getParameter("customerId");
		String password = request.getParameter("password");
		boolean isValidLogin = AdminLogin.adminLogin(customerId, password);
		if (isValidLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("ROLE", "ADMIN");
			response.sendRedirect("PriceList.jsp");
		} else {
			String errorMessage = "Invalid login credentials";
			response.sendRedirect("AdminLogin.jsp?errorMessage=" + errorMessage);
		}
	}
}
