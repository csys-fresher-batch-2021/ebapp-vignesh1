package in.vignesh.validator;

import in.vignesh.exception.RegistrationValidationException;
import in.vignesh.exception.ValidationException;
import in.vignesh.model.UserDetails;

public class RegistrationValidation {
	
	private RegistrationValidation()
	{
		
	}
	public static boolean validRegistration(UserDetails userDetail)
	{
		boolean isValidRegistration=true;
		try {
			if (!(UserValidation.isValidName(userDetail.getName()) && UserValidation.isValidMobile(userDetail.getMobileNo())&& UserValidation.isValidConsumerNo(userDetail.getConsumerNumber()) &&   UserValidation.isValidCustomerId(userDetail.getCustomerId() )) ) {
				isValidRegistration=false;
			}
			if(!UserValidation.isValidPassword(userDetail.getPassword()) 
					&& !UserValidation.isValidPassword(userDetail.getConfirmPassword())) {
				isValidRegistration=false;
			}
		} catch (ValidationException e) {
			e.printStackTrace();
			throw new RegistrationValidationException("Enter all details correctly");
		}
		return isValidRegistration;
	}

}
