package ffse1704.jsfstaff.entity;

public class hoKhau {
	private int id;
	private String thanhPho;
	private String maTP;

	public hoKhau() {

	}

	public hoKhau(int id, String thanhPho, String maTP) {
		super();
		this.id = id;
		this.thanhPho = thanhPho;
		this.maTP = maTP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThanhPho() {
		return thanhPho;
	}

	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}

	public String getMaTP() {
		return maTP;
	}

	public void setMaTP(String maTP) {
		this.maTP = maTP;
	}

}
