package quanlyhocsinh.entity.monhoc;

import quanlyhocsinh.entity.giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {

	public TinHocVanPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	String tenMonHoc = "Tin Hoc Van Phong";
	GiangVien giangVien;

	public TinHocVanPhong(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	public String gettenMonHoc() {
		return tenMonHoc;
	}

	public void settenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmailGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getEmailGiangVien();
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Tin Hoc Van Phong";
	}

}
