package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class TinHocVanPhong implements MonHoc {
	GiangVien giangVien;
	public TinHocVanPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public GiangVien getGiangVien() {
		return giangVien;
	}
	
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}


	
}
