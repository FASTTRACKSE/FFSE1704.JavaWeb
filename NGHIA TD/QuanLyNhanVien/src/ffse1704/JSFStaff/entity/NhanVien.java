package ffse1704.JSFStaff.entity;

public class NhanVien {
	
	private String id;
	private String name;
	private String birthDay;
	private String genDer;
	private String address;
	private String images;
	public NhanVien(String id, String name, String birthDay, String genDer, String address, String images) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.genDer = genDer;
		this.address = address;
		this.images = images;
	}
	
	public NhanVien(String name, String birthDay, String genDer, String address, String images) {
		this.name = name;
		this.birthDay = birthDay;
		this.genDer = genDer;
		this.address = address;
		this.images = images;
	}
	public NhanVien() {
		
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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGenDer() {
		return genDer;
	}

	public void setGenDer(String genDer) {
		this.genDer = genDer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}
}
