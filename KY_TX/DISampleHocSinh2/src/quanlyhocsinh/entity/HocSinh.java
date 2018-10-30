package quanlyhocsinh.entity;

import loaihinhdaotao.entity.LoaiHinhDaoTao;
import quanlyhedaotao.entity.HeDaoTao;
import quanlymonhoc.entity.MonHoc;

public class HocSinh {
	String name;
	int birth;
	String address;
	String numberphone;
	String email;
	MonHoc monHoc;
	LoaiHinhDaoTao loaiHinhDaoTao;
	HeDaoTao heDaoTao;

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public LoaiHinhDaoTao getLoaiHinhDaoTao() {
		return loaiHinhDaoTao;
	}

	public void setLoaiHinhDaoTao(LoaiHinhDaoTao loaiHinhDaoTao) {
		this.loaiHinhDaoTao = loaiHinhDaoTao;
	}

	public String getName() {
		return name;
	}

	public String getThongTinSinhVien() {
		return name + "--" + birth + "---" + address + "---" + numberphone + "---" + email;
	}

	public String getThongTinHeDaoTao() {
		return heDaoTao.getMaHeDaoTao() + heDaoTao.getThongTinHeDaoTao();
	}

	public String getThongTinLoaiHinhDaoTao() {
		return loaiHinhDaoTao.getTenLoaiHinhDaoTao() + " ---" + loaiHinhDaoTao.getDiaChiDaoTao()
				+ loaiHinhDaoTao.getThoiGianDaoTao();
	}

	public HocSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HocSinh(String name, int birth, String address, String numberphone, String email, MonHoc monHoc,
			LoaiHinhDaoTao loaiHinhDaoTao, HeDaoTao heDaoTao) {
		super();
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.numberphone = numberphone;
		this.email = email;
		this.monHoc = monHoc;
		this.loaiHinhDaoTao = loaiHinhDaoTao;
		this.heDaoTao = heDaoTao;
	}

	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberphone() {
		return numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
