package todo.form;

import java.sql.Date;

public class UpdateForm {
	private int index;
	private String title;
	private String priority;
	private Date limit;
	
	public UpdateForm(int index, String title, String priority, Date limit) {
		super();
		this.index = index;
		this.title = title;
		this.priority = priority;
		this.limit = limit;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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
