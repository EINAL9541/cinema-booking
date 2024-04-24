package module;

public class StaffMember {
	private int sid,ssalary;
	private String sname,sphonenumber,spassword;
	
	
	public StaffMember(int sId, String sName, String sPhoneNumber, String sPassword, int sSalary) {
		super();
		this.sid = sId;
		this.sname = sName;
		this.sphonenumber = sPhoneNumber;
		this.spassword = sPassword;
		this.ssalary = sSalary;
	}
	
	
	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public int getSsalary() {
		return ssalary;
	}


	public void setSsalary(int ssalary) {
		this.ssalary = ssalary;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSphonenumber() {
		return sphonenumber;
	}


	public void setSphonenumber(String sphonenumber) {
		this.sphonenumber = sphonenumber;
	}


	public String getSpassword() {
		return spassword;
	}


	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}


	@Override
	public String toString() {
		return "StaffMumber [sId=" + sid + ", sName=" + sname + ", sPhoneNumber="
				+ sphonenumber + ", sPassword=" + spassword +", sSalary=" + ssalary +"]";
	}
	
	
	
}
