package in.vignesh.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vignesh.dao.EditUserDAO;
import in.vignesh.model.UserBean;

/**
 * Servlet implementation class EditSevlet
 */
@WebServlet("/EditSevlet")
public class EditSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("inside edit section");
		UserBean userBean = new UserBean();
		userBean.setUserid(Integer.parseInt(request.getParameter("id")));
		userBean.setUseremail(request.getParameter("email"));
		userBean.setName(request.getParameter("uname"));
		userBean.setUseraddress(request.getParameter("address"));
		userBean.setUserphone(request.getParameter("phone"));
		EditUserDAO dao2 = new EditUserDAO();
		try {
			int result = dao2.editUser(userBean);
			System.out.println("result is " + result);
			String msg = "User edited successfully!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("edituser.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	}



