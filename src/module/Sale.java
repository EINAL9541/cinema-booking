package module;

public class Sale {
	private int sid;
	private String sname,stherater,sshowtime,sdate,sreserve,smname,sshowTime;
	private int sprice;
	
	public Sale(int sid, String sname, String stherater, String sshowtime, String sdate, String sreserve, String smname,
			String sshowTime2, int sprice) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.stherater = stherater;
		this.sshowtime = sshowtime;
		this.sdate = sdate;
		this.sreserve = sreserve;
		this.smname = smname;
		sshowTime = sshowTime2;
		this.sprice = sprice;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getStherater() {
		return stherater;
	}

	public void setStherater(String stherater) {
		this.stherater = stherater;
	}

	public String getSshowtime() {
		return sshowtime;
	}

	public void setSshowtime(String sshowtime) {
		this.sshowtime = sshowtime;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getSreserve() {
		return sreserve;
	}

	public void setSreserve(String sreserve) {
		this.sreserve = sreserve;
	}

	public String getSmname() {
		return smname;
	}

	public void setSmname(String smname) {
		this.smname = smname;
	}

	public String getSshowTime() {
		return sshowTime;
	}

	public void setSshowTime(String sshowTime) {
		this.sshowTime = sshowTime;
	}

	public int getSprice() {
		return sprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}	
	
	
	
	
}
