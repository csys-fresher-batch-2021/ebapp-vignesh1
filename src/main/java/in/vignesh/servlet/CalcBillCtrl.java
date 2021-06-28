package in.vignesh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vignesh.dao.CalcDAO;
import in.vignesh.model.CalcBill;
import in.vignesh.util.ConnectionUtil;

/**
 * Servlet implementation class CalcBillCtrl
 */
@WebServlet("/CalcBillCtrl")
public class CalcBillCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BILL = "bill";
	private static final String PAYBILL = "paybill";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
		request.getRequestDispatcher("paybill.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("Action").equals("Calculate Bill")) {
			try {
				CalcBill bill = new CalcBill();
				bill.setUserid(Integer.parseInt(request.getParameter("userid")));
				bill.setType(request.getParameter("type"));
				bill.setUnitConsumed(Double.parseDouble(request.getParameter("unit")));
				bill.setZoneName(request.getParameter("zonename"));
				bill.setConsumernumber(request.getParameter("consumerno"));
				bill.setMonth(request.getParameter("month"));
				bill.setName(request.getParameter("name"));
				bill.setCustomerid(request.getParameter("customerid"));
				bill.setYear(request.getParameter("year"));
				bill.setStatus("Not Paid");
				bill.setDues(Double.parseDouble(request.getParameter("dues")));
				LocalDate date = LocalDate.now();
				String year = String.valueOf(date.getYear());
				CalcDAO calcDAO = new CalcDAO();
				if (bill.getYear().equals(year)) {
					if (!calcDAO.billExists(bill)) {
						calcDAO.calculateBill(bill);
						HttpSession httpSession = request.getSession();
						httpSession.setAttribute("bill", BILL);
						String msg = "Bill Calculated";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);

					} else {
						String msg = "Bill  Already Calculated";
						request.setAttribute("msg", msg);
						request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
					}
				} else {
					String msg = "Enter Year correctly";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("CalculateBillView.jsp").forward(request, response);
				}
			} catch (ServletException | IOException e) {
				e.printStackTrace();

			}

		}

		if (request.getParameter("Action").equals("Search")) {
			Connection connection = null;
			Statement st = null;
			connection = ConnectionUtil.getConnection();
			System.out.println("inside search");
			try {
				int id = Integer.parseInt(request.getParameter(("userid")));
				connection = ConnectionUtil.getConnection();
				st = connection.createStatement();
				ArrayList list = null;
				ArrayList uid = new ArrayList();
				String query = "SELECT * FROM E_USER WHERE USERID='" + id + "'";
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					list = new ArrayList();
					list = new ArrayList();
					list.add(rs.getInt("USERID"));
					list.add(rs.getString("NAME"));
					list.add(rs.getString("CONSUMERNO"));
					list.add(rs.getString("CUSTOMERID"));
					list.add(rs.getString("USERADDRESS"));

					uid.add(list);
				}
				request.setAttribute("UList", uid);

				RequestDispatcher view = request.getRequestDispatcher("CalculateBillView.jsp");
				view.forward(request, response);

			} catch (SQLException | ServletException | IOException | NumberFormatException e) {
				e.printStackTrace();
			} finally {
				ConnectionUtil.close(st, connection);
			}

		}

		if (request.getParameter("Action").equals("Pay Bill")) {
			System.out.println("inside pay bill");
			try {
				CalcBill paybill = new CalcBill();
				paybill.setCid(Integer.parseInt(request.getParameter("id")));
				paybill.setPayamt(Double.parseDouble(request.getParameter("bamt")));
				paybill.setStatus("PAID");
				CalcDAO calcDAO2 = new CalcDAO();
				paybill = calcDAO2.payAmount(paybill);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("pay", PAYBILL);
				request.setAttribute("msg", "Bill Paid Successfully!!!");

				request.getRequestDispatcher("PaymentSuccess.jsp").forward(request, response);
			} catch (ServletException | IOException | NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}

}