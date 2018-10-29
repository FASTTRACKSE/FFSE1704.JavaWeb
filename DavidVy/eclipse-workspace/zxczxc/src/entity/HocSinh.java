package entity;

import monhoc.MonHoc;

public class HocSinh {
	String hoten;
	int namsinh;
	String diachi;
	String dienthoai;
	String email;
	
	HeDaoTao heDaoTao;
	MonHoc monHoc;
	
	public String getMonHoc() {
		return monHoc.getTenMonHoc();
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public String getthongtinsinhvien() {
		return hoten + " - " + namsinh + " - " + email + " - " + dienthoai + " - " + diachi;
	}
	
	public HeDaoTao getHeDaoTao() {
		return heDaoTao;
	}

	public void setHeDaoTao(HeDaoTao heDaoTao) {
		this.heDaoTao = heDaoTao;
	}

	public String getthongtinhedaotao() {
		return heDaoTao.getMaHeDaoTao()+ " - "+heDaoTao.getthongtinHeDaoTao();
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public HocSinh(String hoten, int namsinh, String diachi, String dienthoai, String email, HeDaoTao heDaoTao) {
		super();
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diachi = diachi;
		this.dienthoai = dienthoai;
		this.email = email;
		this.heDaoTao = heDaoTao;
	}
	
	public HocSinh() {
		super();
	}

}
