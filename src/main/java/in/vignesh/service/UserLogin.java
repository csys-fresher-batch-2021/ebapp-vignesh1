package in.vignesh.service;
import in.vignesh.exception.DBException;
import in.vignesh.exception.ServiceException;
import in.vignesh.dao.LoginDao;

public class UserLogin {
	private UserLogin()
	{
		
	}
	public static boolean validLogin(String customerId,String password)
	{
		boolean validLogin=false;
		try {
			LoginDao dao=new LoginDao();
			validLogin = dao.loginDao(customerId,password);
		} catch (DBException e) {
			throw new ServiceException("unable to verify user credentials");
		}
		return validLogin;
		
	}

}
