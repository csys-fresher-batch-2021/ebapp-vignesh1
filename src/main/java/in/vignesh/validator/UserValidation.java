package in.vignesh.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
	private UserValidation() {

	}

	public static boolean isValidName(String name) {
		boolean validName = false;

		Pattern pattern = Pattern.compile("^[a-zA-Z+\\s]+$");
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			validName = true;

		}
		return validName;

	}

	public static boolean isValidMobile(String mobileNo) {
		boolean validMobile = false;

		Pattern pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		Matcher matcher = pattern.matcher(mobileNo);
		if (matcher.matches()) {
			validMobile = true;

		}
		return validMobile;

	}

	public static boolean isValidConsumerNo(String consumerNo)

	{
		boolean validConsumerNo = false;
		Pattern pattern = Pattern.compile("[0]{1}[1-9]{1}[0-9]{10}");
		Matcher matcher = pattern.matcher(consumerNo);
		if (matcher.matches()) {
			validConsumerNo = true;
		}
		return validConsumerNo;

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
