package module;

public class DayIncome {
	private String day;
	private int income;
	public DayIncome(String day, int income) {
		super();
		this.day = day;
		this.income = income;
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "DayIncome [day=" + day + ", income=" + income + "]";
	}
	
	
}
