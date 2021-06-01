package in.vignesh.service;

import java.util.List;


import in.vignesh.dao.RegistrationDao;
import in.vignesh.exception.DBException;
import in.vignesh.exception.RegistrationValidationException;
import in.vignesh.exception.ServiceException;
import in.vignesh.model.UserDetails;
import in.vignesh.validator.RegistrationValidation;

public class UserRegistration {
	private UserRegistration()
	{
		
	}
	public static boolean userRegistration(UserDetails userDetail)
	{
		boolean validRegistration=false;
		try {
			if(RegistrationValidation.validRegistration(userDetail)){
				RegistrationDao dao=new RegistrationDao();
				dao.addUserDetail(userDetail);
				validRegistration=true;
			}
		} catch (DBException| RegistrationValidationException e) {
			throw new ServiceException("unable to register");
		}
		return validRegistration;
		
	}
	public static boolean existingUser(UserDetails userDetail)
	{
		boolean isMatched=false;
			try {
				RegistrationDao dao=new RegistrationDao();
				List<UserDetails> userList=dao.getAllUser();
				for (UserDetails user : userList) {

					if (user.getName().equalsIgnoreCase(userDetail.getName())
							&& user.getMobileNo().equals(userDetail.getMobileNo())
							&& user.getConsumerNumber().equals(userDetail.getConsumerNumber())
							&& user.getCustomerId().equalsIgnoreCase(userDetail.getCustomerId())
							&& user.getPassword().equalsIgnoreCase(userDetail.getPassword())
							&& user.getConfirmPassword().equalsIgnoreCase(userDetail.getConfirmPassword())){
						isMatched = true;
						break;

					}

				}
			} catch (DBException e) {
				throw new ServiceException("unable to fetch userdetail in database");
			}
			return isMatched;
	}

}
