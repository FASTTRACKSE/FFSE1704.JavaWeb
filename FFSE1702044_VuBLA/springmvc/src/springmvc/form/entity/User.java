package springmvc.form.entity;

public class User {
	String id;
	String name,monhoc;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String monhoc) {
		super();
		this.id = id;
		this.name = name;
		this.monhoc = monhoc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMonhoc() {
		return monhoc;
	}
	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}
	
}
