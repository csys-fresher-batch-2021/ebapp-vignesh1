package in.vignesh.model;

public class UserDetails {
	private String name;
	private String mobileNo;
	private String consumerNumber;
	private String customerId;
	private String password;
	private String confirmPassword;

	public String getName() {
		return name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getConsumerNumber() {
		return consumerNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public UserDetails(String name, String mobileNo, String consumerNumber, String customerId, String password, String confirmPassword2) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.consumerNumber = consumerNumber;
		this.customerId = customerId;
		this.password = password;
	}
	

}