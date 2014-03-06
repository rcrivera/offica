package uprm.icom5016.dtos;

public class Report {

	String year,month,day,week,resetweek,pid,total;

	public Report(String year, String month, String day, String week,
			String resetweek, String pid, String total) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.week = week;
		this.resetweek = resetweek;
		this.pid = pid;
		this.total = total;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getResetweek() {
		return resetweek;
	}

	public void setResetweek(String resetweek) {
		this.resetweek = resetweek;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
}
