package ffse1704.entity;

public class SinhVien {
	private int id;
	private String masv;
	private String tensv;
	private String namsinh;
	private String email;
	private String diachi;
	private String lophoc;
	private String image;
	
	public SinhVien(int id, String masv, String tensv, String namsinh, String email, String diachi, String lophoc,
			String image) {
		super();
		this.id = id;
		this.masv = masv;
		this.tensv = tensv;
		this.namsinh = namsinh;
		this.email = email;
		this.diachi = diachi;
		this.lophoc = lophoc;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMasv() {
		return masv;
	}

	public void setMasv(String masv) {
		this.masv = masv;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getLophoc() {
		return lophoc;
	}

	public void setLophoc(String lophoc) {
		this.lophoc = lophoc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	
}
