package todo;

import java.sql.Date;

public class IndexForm {
	private String title;
	private String priority;
	private Date limit;
	private String check;

	public IndexForm(String title, String priority, Date limit, String check){
		this.title = title;
		this.priority = priority;
		this.limit = limit;
		this.check = check;
	}

	
	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getLimit() {
		return limit;
	}

	public void setLimit(Date limit) {
		this.limit = limit;
	}
	
	
	
}
