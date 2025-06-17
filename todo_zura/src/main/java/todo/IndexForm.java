package todo;

import java.sql.Date;

public class IndexForm {
	private int id;
	private String title;
	private String priority;
	private Date limit_date;
	private boolean is_done;

	public IndexForm(int id, String title, String priority, Date limit_date, boolean is_done) {
		this.id = id;
		this.title = title;
		this.priority = priority;
		this.limit_date = limit_date;
		this.is_done = is_done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getLimit_date() {
		return limit_date;
	}

	public void setLimit_date(Date limit_date) {
		this.limit_date = limit_date;
	}

	public boolean isDone() {
		return is_done;
	}

	public void setDone(boolean is_done) {
		this.is_done = is_done;
	}
	
	
}