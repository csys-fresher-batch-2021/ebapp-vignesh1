package in.vignesh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vignesh.model.CalcBill;
import in.vignesh.util.ConnectionUtil;
import in.vignesh.dao.CalcDAO;


/**
 * Servlet implementation class CalcBillCtrl
 */
@WebServlet("/CalcBillCtrl")
public class CalcBillCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
		request.getRequestDispatcher("paybill.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Action").equals("Calculate Bill")) 
		{
			CalcBill bill = new CalcBill();
			bill.setUserid(Integer.parseInt(request.getParameter("userid")));
			bill.setType(request.getParameter("type"));
			bill.setUnitConsumed(Integer.parseInt(request.getParameter("unit")));
			bill.setZoneName(request.getParameter("zonename"));
			bill.setMonth(request.getParameter("month"));
			bill.setName(request.getParameter("name"));
			bill.setCustomerid(request.getParameter("name"));
			bill.setYear(request.getParameter("year"));
			bill.setStatus("Not Paid");
			bill.setDues(Integer.parseInt(request.getParameter("dues")));
			CalcDAO calcDAO = new CalcDAO();
			calcDAO.calculateBill(bill);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("bill", bill);
			String msg = "Bill Calculated";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
		}

		if(request.getParameter("Action").equals("Search"))
		{
			Connection connection=null;
			Statement st=null;
		     connection = ConnectionUtil.getConnection();
			System.out.println("inside search");
			int id=Integer.parseInt(request.getParameter(("userid")));		
			try {
			     connection = ConnectionUtil.getConnection();
				 st=connection.createStatement();
				    ArrayList list=null;
					ArrayList uid=new ArrayList();
					String query="SELECT * FROM E_USER WHERE USERID='"+id+"'";
				 ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{   

					list=new ArrayList();
					list.add(rs.getInt(1));
					list.add(rs.getString(2));
					list.add(rs.getString(5));
					uid.add(list);
				}
				request.setAttribute("UList", uid);

	            RequestDispatcher view = request.getRequestDispatcher("CalculateBillView.jsp");
	            view.forward(request, response);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				ConnectionUtil.close(st, connection);
			}

		}


		if (request.getParameter("Action").equals("Pay Bill"))
		{
			System.out.println("inside pay bill");
			CalcBill bill2 = new CalcBill();
			bill2.setCid(Integer.parseInt(request.getParameter("id")));
			bill2.setPayamt(Integer.parseInt(request.getParameter("bamt")));
			bill2.setStatus("PAID");
            CalcDAO calcDAO2 = new CalcDAO();
			bill2 = calcDAO2.payAmount(bill2);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("pay", bill2);
			request.setAttribute("msg", "Bill Paid Successfully!!!");
			request.getRequestDispatcher("paybill.jsp").forward(request, response);
		}
	}

}
