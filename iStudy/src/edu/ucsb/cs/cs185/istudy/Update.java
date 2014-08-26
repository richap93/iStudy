package edu.ucsb.cs.cs185.istudy;

public class Update {
	
	private String message;
	private String content;
	private String dateTime;
	private int icon;
	
	public Update(String message, String content, String dateTime, int icon) {

		this.message = message;
		this.content = content;
		this.dateTime = dateTime;
		this.icon = icon;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
	

}
