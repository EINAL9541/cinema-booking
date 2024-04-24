package module;

public class Price {
	private int seatid;
	private String seatname;
	private int seatprice;
	
	public Price(int seatid, String seatname, int seatprice) 
	{
		super();
		this.seatid = seatid;
		this.seatname = seatname;
		this.seatprice = seatprice;
	}

	public int getSeatid() {
		return seatid;
	}

	public void setSeatid(int seatid) {
		this.seatid = seatid;
	}

	public String getSeatname() {
		return seatname;
	}

	public void setSeatname(String seatname) {
		this.seatname = seatname;
	}

	public int getSeatprice() {
		return seatprice;
	}

	public void setSeatprice(int seatprice) {
		this.seatprice = seatprice;
	}
	
	
	
}
