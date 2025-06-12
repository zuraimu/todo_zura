package todo;

import java.sql.Date;

public class IndexForm {
	private String title;
	private String priority;
	private Date limit;

	public IndexForm(String title, String priority, Date limit){
		this.title = title;
		this.priority = priority;
		this.limit = limit;
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
