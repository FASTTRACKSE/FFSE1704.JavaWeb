package fasttrackse.entity;

public class SinhVien {
	String hoTen;
	int namSinh;
	String diaChi;
	String dienThoai;
	String email;
	
	HeDaoTao heDaoTao;
	LoaiHinhDaoTao loaiHinhDaoTao;


	public SinhVien(String hoTen, int namSinh, String diaChi, String dienThoai, String email, HeDaoTao heDaoTao,
			LoaiHinhDaoTao loaiHinhDaoTao) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}

	public String getThongTinSinhVien() {
		return hoTen + "  - " + namSinh + " - " + email + " - " + dienThoai ;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + " - " + heDaoTao.getThongTinHeDaoTao();
	}

	public String getLoaiHinhDaoTao() {
		return loaiHinhDaoTao.getMaLoaiHinhDaoTao()+ " - "+loaiHinhDaoTao.getTenLoaiHinhDaoTao()+" - "+ loaiHinhDaoTao.getDiaChi() + " - "+ loaiHinhDaoTao.getThoiGian();
	}

	public void setLoaiHinhDaoTao(LoaiHinhDaoTao loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
