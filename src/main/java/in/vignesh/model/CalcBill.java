package in.vignesh.model;

public class CalcBill {
private int cid;
private int userid;
private String type;
private String customerid;
private double unitConsumed;
private String zoneName;
private String month;
private String name;
private String year;
private String status;
private double dues;
private double payamt;

public double getPayamt() {
	return payamt;
}
public void setPayamt(double payamt) {
	this.payamt = payamt;
}
public double getDues() {
	return dues;
}
public void setDues(double dues) {
	this.dues = dues;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public double getUnitConsumed() {
	return unitConsumed;
}
public void setUnitConsumed(double unitConsumed) {
	this.unitConsumed = unitConsumed;
}
public String getZoneName() {
	return zoneName;
}
public void setZoneName(String zoneName) {
	this.zoneName = zoneName;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCustomerid() {
	return customerid;
}
public void setCustomerid(String customerid) {
	this.customerid = customerid;
}



}
