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
 * Servlet implementation class EditMyServlet
 */
@WebServlet("/EditMyServlet")
public class EditMyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("inside edit section");
				UserBean userBean = new UserBean();
				userBean.setUserid(Integer.parseInt(request.getParameter("id")));
				userBean.setName(request.getParameter("uname"));
				userBean.setUseremail(request.getParameter("email"));
				userBean.setUseraddress(request.getParameter("address"));
				userBean.setUserphone(request.getParameter("phone"));
				userBean.setPassword(request.getParameter("password"));
				EditUserDAO dao2 = new EditUserDAO();
				int result = dao2.editMyProfile(userBean);
				System.out.println("result is " + result);
				String msg = "Profile edited successfully!!";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("editprofileView.jsp").forward(request, response);
			}

		}

