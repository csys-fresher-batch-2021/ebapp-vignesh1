package in.vignesh.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.vignesh.service.TotalBill;

/**
 * Servlet implementation class GenerateBill
 */
@WebServlet("/GenerateBill")
public class GenerateBill extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {

			Double units = Double.parseDouble(request.getParameter("units"));
			String type = request.getParameter("type");
			double total = TotalBill.getTotalBill(type, units);

			response.sendRedirect("result.jsp?totalBillAmount=" + total);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();

		}

	}
}
