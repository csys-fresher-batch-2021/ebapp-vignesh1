package in.vignesh.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
	private UserValidation() {

	}

	public static boolean isValidCustomerId(String customerId) {
		boolean validCustomerId = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z]([._-](?![._-])|[a-zA-Z0-9]){4,15}[a-zA-Z0-9]$");
		Matcher matcher = pattern.matcher(customerId);
		if (matcher.matches()) {
			validCustomerId = true;
		}
		return validCustomerId;

	}

	public static boolean isValidPassword(String password) {
		boolean validPassword = false;

		Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^)])(?=\\S+$).{8,20}$");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			validPassword = true;
		}
		return validPassword;

	}
}
