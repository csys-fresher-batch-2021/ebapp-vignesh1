package in.vignesh.validator;

import in.vignesh.exception.RegistrationValidationException;
import in.vignesh.exception.ValidationException;
import in.vignesh.model.UserBean;

public class RegisterValidator {
	
	private RegisterValidator()
	{
		
	}
	public static boolean validRegistration(UserBean userDetail)
	{
		boolean isValidRegistration=true;
		try {
			if (!(UserValidation.isValidName(userDetail.getName()) && UserValidation.isValidMobile(userDetail.getUserphone())&& UserValidation.isValidConsumerNo(userDetail.getConsumerNumber()) &&   UserValidation.isValidCustomerId(userDetail.getCustomerId() )) ) {
				isValidRegistration=false;
			}
			if (!( UserValidation.isValidEmail(userDetail.getUseremail()) && UserValidation.isValidAddress(userDetail.getUseraddress()))){
				isValidRegistration=false;
			}
			if(!UserValidation.isValidPassword(userDetail.getPassword()) 
					&& !UserValidation.isValidPassword(userDetail.getConfirmpassword())) {
				isValidRegistration=false;
			}
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new RegistrationValidationException("Enter all details correctly");
		}
		return isValidRegistration;
	}

}
