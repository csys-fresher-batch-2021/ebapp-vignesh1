package in.vignesh.service;

import in.vignesh.dao.AdminDao;
import in.vignesh.exception.DBException;
import in.vignesh.exception.ServiceException;
import in.vignesh.validator.UserValidation;

public class AdminLogin {
	private AdminLogin() {

	}

	public static boolean adminLogin(String customerId, String password) {
		boolean validLogin = false;
		if (UserValidation.isValidCustomerId(customerId) && UserValidation.isValidPassword(password)) {
			AdminDao dao = new AdminDao();
			try {
				validLogin = dao.validAdminLogin(customerId, password);
			} catch (DBException e) {
				throw new ServiceException("invalid Login credentials");
			}

		}
		return validLogin;
	}

}
