package ffse1704.JSFStaff.entity;

public class TinhThanhPho {
	
	private String code;
	private String name;
	private String type;
	public TinhThanhPho(String code, String name, String type) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
	}
	public TinhThanhPho( String name, String type) {
		this.name = name;
		this.type = type;
	}
	public TinhThanhPho() {
	
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
