package in.vignesh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.vignesh.service.TotalBill;

/**
 * Servlet implementation class GenerateBill
 */
@WebServlet("/GenerateBill")
public class GenerateBill extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(GenerateBill.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Double units = Double.parseDouble(request.getParameter("units"));
			String type = request.getParameter("type");
			double total = TotalBill.getTotalBill(type, units);
			// double perUnitPrice = BillManager.getPerUnitPrice(type, units);
//			response.sendRedirect("result.jsp?unit=" + units);
			// response.sendRedirect("result.jsp?PriceAmount=" + perUnitPrice);
			response.sendRedirect("result.jsp?totalBillAmount=" + total);
			// request.setAttribute("perUnitPrice", perUnitPrice);
			// .getRequestDispatcher("result.jsp?PriceAmount=").forward(request, response);
		} catch (NumberFormatException | IOException e) {
			LOGGER.error(e.getMessage());

		}

	}
}
