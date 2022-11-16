package org.project.beans;

public class TimeSheetBean {
	private String id;
	private String date;
	private String timein;
	private String timeout;
	private String MMMYYYY;
	public String getMMMYYYY() {
		return MMMYYYY;
	}
	public void setMMMYYYY(String mMMYYYY) {
		MMMYYYY = mMMYYYY;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimein() {
		return timein;
	}
	public void setTimein(String timein) {
		this.timein = timein;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	
}
