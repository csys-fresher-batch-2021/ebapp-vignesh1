package in.vignesh.service;

import java.util.HashMap;
import java.util.Map;

import in.vignesh.validator.UserValidation;

public class AdminLogin {
	private AdminLogin() {

	}

	private static final Map<String, String> adminDetail = new HashMap<>();
	static {
		adminDetail.put("Admin1", "Admin@123");
		adminDetail.put("Admin2", "Admin@123");
	}

	public static boolean adminLogin(String customerId, String password) {
		boolean validLogin = false;
		if (UserValidation.isValidCustomerId(customerId) && UserValidation.isValidPassword(password)
				&& adminDetail.containsKey(customerId)) {
			String adminPassword = adminDetail.get(customerId);
			if (adminPassword.equals(password)) {
				validLogin = true;
			}
		}
		return validLogin;

	}

}
