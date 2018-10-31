package monhoc;

import giangvien.GiangVien;

public class MonHocLapTrinhWeb implements MonHoc {
    public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	GiangVien giangVien; 
	public String getThongTinMonHoc() {
		return " Lập trình web";
	}
public String getTenGiangVien() {
	 return giangVien.getTenGiangVien();
}

public String getEmailGiangVien() {
	 return giangVien.getEmailGiangVien();
}
}
